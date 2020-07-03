package com.baidu.tieba.ala.liveroom.i;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.q;
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
/* loaded from: classes3.dex */
public class e implements f {
    private static ApkData ghB;
    private static long ghC = 0;
    private q aLQ;
    private PendantParentView ghA;
    private d ghD;
    private ApkStatusCallback ghE = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.i.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.bEz();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.ghD != null) {
                e.this.ghD.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.i.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.bEC();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.bEC();
        }
    };
    private String ghi;
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (ghB != null && ghC != 0) {
            ghB.apkStatusCallBack = this.ghE;
        }
    }

    public void b(q qVar, PendantParentView pendantParentView) {
        this.aLQ = qVar;
        this.ghA = pendantParentView;
        if (isDownloading() && qVar != null && qVar.mLiveInfo != null) {
            bEz();
            if (this.ghD != null) {
                if (qVar.mLiveInfo.live_id == ghC) {
                    this.ghD.kY(false);
                } else {
                    this.ghD.kY(true);
                }
            }
        }
    }

    public void bCS() {
        bEB();
    }

    public void bEy() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), ghB, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEz() {
        if (isDownloading()) {
            bEA();
        }
    }

    private void bEA() {
        if (this.ghD == null) {
            this.ghD = new d(this.mPageContext.getPageActivity());
            this.ghD.setProgress(0);
            this.ghD.kY(false);
        }
        if (this.ghD.bEx() != null && this.ghD.bEx().getParent() == null && this.ghA != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams.gravity = 5;
            this.ghA.a(this.ghD.bEx(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void bEB() {
        if (this.ghD != null && this.ghD.bEx() != null && this.ghD.bEx().getParent() != null) {
            ((ViewGroup) this.ghD.bEx().getParent()).removeView(this.ghD.bEx());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEC() {
        ghC = 0L;
        if (ghB != null) {
            ghB.apkStatusCallBack = null;
            ghB = null;
        }
        bEB();
        this.ghD = null;
    }

    public void bT(boolean z) {
        if (z && ghB != null) {
            ApkManager.getInstance().stopApkDownload(ghB);
            bEC();
        } else if (ghB != null) {
            ghB.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public boolean isDownloading() {
        return (ghC == 0 || ghB == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public ApkStatus a(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public void b(final ApkData apkData) {
        ApkStatus a = a(apkData);
        if (a == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m20clone());
        } else if (a == ApkStatus.DOWNLOADED) {
            ghB = apkData.m20clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m20clone(), false);
        } else if (a == ApkStatus.NONE || a == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && k.Jk()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.ghi);
                            dialogInterface.dismiss();
                            return true;
                        }
                        return false;
                    }
                });
                bdAlertDialog.setCanceledOnTouchOutside(false);
                bdAlertDialog.setTitle(this.mPageContext.getResources().getString(a.i.ala_feedback_flow_download_net_title));
                bdAlertDialog.setMessage(this.mPageContext.getResources().getString(a.i.ala_feedback_flow_download_net_tip));
                bdAlertDialog.setPositiveButton(this.mPageContext.getResources().getString(a.i.sdk_go_on), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.3
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        e.this.c(apkData);
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.ghi);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.i.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.ghi);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.ghi);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        ghB = apkData.m20clone();
        ghB.apkStatusCallBack = this.ghE;
        if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
            ghC = this.aLQ.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), ghB, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public void CT(String str) {
        this.ghi = str;
    }

    public void setVisible(int i) {
        if (this.ghD != null && this.ghD.bEx() != null) {
            this.ghD.bEx().setVisibility(i);
        }
    }
}
