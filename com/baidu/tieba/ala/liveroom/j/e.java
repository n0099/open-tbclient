package com.baidu.tieba.ala.liveroom.j;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.u;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkManager;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.apk.ApkStatusCallback;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.l;
/* loaded from: classes4.dex */
public class e implements f {
    private static ApkData gQY;
    private static long gQZ = 0;
    private u aDU;
    private String gQF;
    private PendantParentView gQX;
    private d gRa;
    private ApkStatusCallback gRb = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.j.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.bWz();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.gRa != null) {
                e.this.gRa.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.i.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.bWC();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.bWC();
        }
    };
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (gQY != null && gQZ != 0) {
            gQY.apkStatusCallBack = this.gRb;
        }
    }

    public void b(u uVar, PendantParentView pendantParentView) {
        this.aDU = uVar;
        this.gQX = pendantParentView;
        if (isDownloading() && uVar != null && uVar.mLiveInfo != null) {
            bWz();
            if (this.gRa != null) {
                if (uVar.mLiveInfo.live_id == gQZ) {
                    this.gRa.mL(false);
                } else {
                    this.gRa.mL(true);
                }
            }
        }
    }

    public void bUw() {
        bWB();
    }

    public void bWy() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), gQY, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWz() {
        if (isDownloading()) {
            bWA();
        }
    }

    private void bWA() {
        if (this.gRa == null) {
            this.gRa = new d(this.mPageContext.getPageActivity());
            this.gRa.setProgress(0);
            this.gRa.mL(false);
        }
        if (this.gRa.bWx() != null && this.gRa.bWx().getParent() == null && this.gQX != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams.gravity = 5;
            this.gQX.a(this.gRa.bWx(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void bWB() {
        if (this.gRa != null && this.gRa.bWx() != null && this.gRa.bWx().getParent() != null) {
            ((ViewGroup) this.gRa.bWx().getParent()).removeView(this.gRa.bWx());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWC() {
        gQZ = 0L;
        if (gQY != null) {
            gQY.apkStatusCallBack = null;
            gQY = null;
        }
        bWB();
        this.gRa = null;
    }

    public void ce(boolean z) {
        if (z && gQY != null) {
            ApkManager.getInstance().stopApkDownload(gQY);
            bWC();
        } else if (gQY != null) {
            gQY.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public boolean isDownloading() {
        return (gQZ == 0 || gQY == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public ApkStatus a(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void b(final ApkData apkData) {
        ApkStatus a2 = a(apkData);
        if (a2 == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m22clone());
        } else if (a2 == ApkStatus.DOWNLOADED) {
            gQY = apkData.m22clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m22clone(), false);
        } else if (a2 == ApkStatus.NONE || a2 == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && l.QR()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.gQF);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.gQF);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.i.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.gQF);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.gQF);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        gQY = apkData.m22clone();
        gQY.apkStatusCallBack = this.gRb;
        if (this.aDU != null && this.aDU.mLiveInfo != null) {
            gQZ = this.aDU.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), gQY, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void Ho(String str) {
        this.gQF = str;
    }

    public void setVisible(int i) {
        if (this.gRa != null && this.gRa.bWx() != null) {
            this.gRa.bWx().setVisibility(i);
        }
    }
}
