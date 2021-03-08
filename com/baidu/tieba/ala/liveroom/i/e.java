package com.baidu.tieba.ala.liveroom.i;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.ab;
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
    private static ApkData hFo;
    private static long hFp = 0;
    private ab aED;
    private String hEX;
    private PendantParentView hFn;
    private d hFq;
    private ApkStatusCallback hFr = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.i.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onJoinDownloadQueue() {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.cfu();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.hFq != null) {
                e.this.hFq.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.h.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.cfx();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.cfx();
        }
    };
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (hFo != null && hFp != 0) {
            hFo.apkStatusCallBack = this.hFr;
        }
    }

    public void b(ab abVar, PendantParentView pendantParentView) {
        this.aED = abVar;
        this.hFn = pendantParentView;
        if (isDownloading() && abVar != null && abVar.mLiveInfo != null) {
            cfu();
            if (this.hFq != null) {
                if (abVar.mLiveInfo.live_id == hFp) {
                    this.hFq.on(false);
                } else {
                    this.hFq.on(true);
                }
            }
        }
    }

    public void cdt() {
        cfw();
    }

    public void cft() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hFo, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfu() {
        if (isDownloading()) {
            cfv();
        }
    }

    private void cfv() {
        if (this.hFq == null) {
            this.hFq = new d(this.mPageContext.getPageActivity());
            this.hFq.setProgress(0);
            this.hFq.on(false);
        }
        if (this.hFq.cfs() != null && this.hFq.cfs().getParent() == null && this.hFn != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams.gravity = 5;
            this.hFn.a(this.hFq.cfs(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void cfw() {
        if (this.hFq != null && this.hFq.cfs() != null && this.hFq.cfs().getParent() != null) {
            ((ViewGroup) this.hFq.cfs().getParent()).removeView(this.hFq.cfs());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfx() {
        hFp = 0L;
        if (hFo != null) {
            hFo.apkStatusCallBack = null;
            hFo = null;
        }
        cfw();
        this.hFq = null;
    }

    public void cF(boolean z) {
        if (z && hFo != null) {
            ApkManager.getInstance().stopApkDownload(hFo);
            cfx();
        } else if (hFo != null) {
            hFo.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public boolean isDownloading() {
        return (hFp == 0 || hFo == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public ApkStatus b(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public void c(final ApkData apkData) {
        ApkStatus b = b(apkData);
        if (b == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m20clone());
        } else if (b == ApkStatus.DOWNLOADED) {
            hFo = apkData.m20clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m20clone(), false);
        } else if (b == ApkStatus.NONE || b == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && m.Vs()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hEX);
                            dialogInterface.dismiss();
                            return true;
                        }
                        return false;
                    }
                });
                bdAlertDialog.setCanceledOnTouchOutside(false);
                bdAlertDialog.setTitle(this.mPageContext.getResources().getString(a.h.ala_feedback_flow_download_net_title));
                bdAlertDialog.setMessage(this.mPageContext.getResources().getString(a.h.ala_feedback_flow_download_net_tip));
                bdAlertDialog.setPositiveButton(this.mPageContext.getResources().getString(a.h.sdk_go_on), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.3
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        e.this.a(apkData);
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.hEX);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.h.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hEX);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.hEX);
                return;
            }
            a(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApkData apkData) {
        hFo = apkData.m20clone();
        hFo.apkStatusCallBack = this.hFr;
        if (this.aED != null && this.aED.mLiveInfo != null) {
            hFp = this.aED.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hFo, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public void HX(String str) {
        this.hEX = str;
    }

    public void setVisible(int i) {
        if (this.hFq != null && this.hFq.cfs() != null) {
            this.hFq.cfs().setVisibility(i);
        }
    }
}
