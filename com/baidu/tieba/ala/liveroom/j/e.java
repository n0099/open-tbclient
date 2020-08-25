package com.baidu.tieba.ala.liveroom.j;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.r;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkManager;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.apk.ApkStatusCallback;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.k;
/* loaded from: classes7.dex */
public class e implements f {
    private static ApkData gzq;
    private static long gzr = 0;
    private r aAh;
    private String gyX;
    private PendantParentView gzp;
    private d gzs;
    private ApkStatusCallback gzt = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.j.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.bRJ();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.gzs != null) {
                e.this.gzs.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.i.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.bRM();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.bRM();
        }
    };
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (gzq != null && gzr != 0) {
            gzq.apkStatusCallBack = this.gzt;
        }
    }

    public void b(r rVar, PendantParentView pendantParentView) {
        this.aAh = rVar;
        this.gzp = pendantParentView;
        if (isDownloading() && rVar != null && rVar.mLiveInfo != null) {
            bRJ();
            if (this.gzs != null) {
                if (rVar.mLiveInfo.live_id == gzr) {
                    this.gzs.me(false);
                } else {
                    this.gzs.me(true);
                }
            }
        }
    }

    public void bPJ() {
        bRL();
    }

    public void bRI() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), gzq, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRJ() {
        if (isDownloading()) {
            bRK();
        }
    }

    private void bRK() {
        if (this.gzs == null) {
            this.gzs = new d(this.mPageContext.getPageActivity());
            this.gzs.setProgress(0);
            this.gzs.me(false);
        }
        if (this.gzs.bRH() != null && this.gzs.bRH().getParent() == null && this.gzp != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams.gravity = 5;
            this.gzp.a(this.gzs.bRH(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void bRL() {
        if (this.gzs != null && this.gzs.bRH() != null && this.gzs.bRH().getParent() != null) {
            ((ViewGroup) this.gzs.bRH().getParent()).removeView(this.gzs.bRH());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRM() {
        gzr = 0L;
        if (gzq != null) {
            gzq.apkStatusCallBack = null;
            gzq = null;
        }
        bRL();
        this.gzs = null;
    }

    public void cb(boolean z) {
        if (z && gzq != null) {
            ApkManager.getInstance().stopApkDownload(gzq);
            bRM();
        } else if (gzq != null) {
            gzq.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public boolean isDownloading() {
        return (gzr == 0 || gzq == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public ApkStatus a(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void b(final ApkData apkData) {
        ApkStatus a = a(apkData);
        if (a == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m23clone());
        } else if (a == ApkStatus.DOWNLOADED) {
            gzq = apkData.m23clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m23clone(), false);
        } else if (a == ApkStatus.NONE || a == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && k.Pj()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.gyX);
                            dialogInterface.dismiss();
                            return true;
                        }
                        return false;
                    }
                });
                bdAlertDialog.setCanceledOnTouchOutside(false);
                bdAlertDialog.setTitle(this.mPageContext.getResources().getString(a.i.ala_feedback_flow_download_net_title));
                bdAlertDialog.setMessage(this.mPageContext.getResources().getString(a.i.ala_feedback_flow_download_net_tip));
                bdAlertDialog.setPositiveButton(this.mPageContext.getResources().getString(a.i.sdk_go_on), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.3
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        e.this.c(apkData);
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.gyX);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.i.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.gyX);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.gyX);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        gzq = apkData.m23clone();
        gzq.apkStatusCallBack = this.gzt;
        if (this.aAh != null && this.aAh.mLiveInfo != null) {
            gzr = this.aAh.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), gzq, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void Gd(String str) {
        this.gyX = str;
    }

    public void setVisible(int i) {
        if (this.gzs != null && this.gzs.bRH() != null) {
            this.gzs.bRH().setVisibility(i);
        }
    }
}
