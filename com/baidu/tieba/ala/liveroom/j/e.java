package com.baidu.tieba.ala.liveroom.j;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.x;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkManager;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.apk.ApkStatusCallback;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.m;
/* loaded from: classes10.dex */
public class e implements f {
    private static ApkData hzg;
    private static long hzh = 0;
    private x aBr;
    private String hyP;
    private PendantParentView hzf;
    private d hzi;
    private ApkStatusCallback hzj = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.j.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onJoinDownloadQueue() {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.cem();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.hzi != null) {
                e.this.hzi.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.h.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.cep();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.cep();
        }
    };
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (hzg != null && hzh != 0) {
            hzg.apkStatusCallBack = this.hzj;
        }
    }

    public void b(x xVar, PendantParentView pendantParentView) {
        this.aBr = xVar;
        this.hzf = pendantParentView;
        if (isDownloading() && xVar != null && xVar.mLiveInfo != null) {
            cem();
            if (this.hzi != null) {
                if (xVar.mLiveInfo.live_id == hzh) {
                    this.hzi.oc(false);
                } else {
                    this.hzi.oc(true);
                }
            }
        }
    }

    public void ccl() {
        ceo();
    }

    public void cel() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hzg, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cem() {
        if (isDownloading()) {
            cen();
        }
    }

    private void cen() {
        if (this.hzi == null) {
            this.hzi = new d(this.mPageContext.getPageActivity());
            this.hzi.setProgress(0);
            this.hzi.oc(false);
        }
        if (this.hzi.cek() != null && this.hzi.cek().getParent() == null && this.hzf != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams.gravity = 5;
            this.hzf.a(this.hzi.cek(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void ceo() {
        if (this.hzi != null && this.hzi.cek() != null && this.hzi.cek().getParent() != null) {
            ((ViewGroup) this.hzi.cek().getParent()).removeView(this.hzi.cek());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cep() {
        hzh = 0L;
        if (hzg != null) {
            hzg.apkStatusCallBack = null;
            hzg = null;
        }
        ceo();
        this.hzi = null;
    }

    public void cw(boolean z) {
        if (z && hzg != null) {
            ApkManager.getInstance().stopApkDownload(hzg);
            cep();
        } else if (hzg != null) {
            hzg.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public boolean isDownloading() {
        return (hzh == 0 || hzg == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public ApkStatus b(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void c(final ApkData apkData) {
        ApkStatus b2 = b(apkData);
        if (b2 == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m21clone());
        } else if (b2 == ApkStatus.DOWNLOADED) {
            hzg = apkData.m21clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m21clone(), false);
        } else if (b2 == ApkStatus.NONE || b2 == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && m.TI()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hyP);
                            dialogInterface.dismiss();
                            return true;
                        }
                        return false;
                    }
                });
                bdAlertDialog.setCanceledOnTouchOutside(false);
                bdAlertDialog.setTitle(this.mPageContext.getResources().getString(a.h.ala_feedback_flow_download_net_title));
                bdAlertDialog.setMessage(this.mPageContext.getResources().getString(a.h.ala_feedback_flow_download_net_tip));
                bdAlertDialog.setPositiveButton(this.mPageContext.getResources().getString(a.h.sdk_go_on), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.3
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        e.this.a(apkData);
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.hyP);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.h.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hyP);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.hyP);
                return;
            }
            a(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApkData apkData) {
        hzg = apkData.m21clone();
        hzg.apkStatusCallBack = this.hzj;
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            hzh = this.aBr.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hzg, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void Hj(String str) {
        this.hyP = str;
    }

    public void setVisible(int i) {
        if (this.hzi != null && this.hzi.cek() != null) {
            this.hzi.cek().setVisibility(i);
        }
    }
}
