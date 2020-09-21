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
    private static ApkData gCF;
    private static long gCG = 0;
    private u aAP;
    private PendantParentView gCE;
    private d gCH;
    private ApkStatusCallback gCI = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.j.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.bTg();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.gCH != null) {
                e.this.gCH.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.i.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.bTj();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.bTj();
        }
    };
    private String gCm;
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (gCF != null && gCG != 0) {
            gCF.apkStatusCallBack = this.gCI;
        }
    }

    public void b(u uVar, PendantParentView pendantParentView) {
        this.aAP = uVar;
        this.gCE = pendantParentView;
        if (isDownloading() && uVar != null && uVar.mLiveInfo != null) {
            bTg();
            if (this.gCH != null) {
                if (uVar.mLiveInfo.live_id == gCG) {
                    this.gCH.mj(false);
                } else {
                    this.gCH.mj(true);
                }
            }
        }
    }

    public void bRc() {
        bTi();
    }

    public void bTf() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), gCF, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTg() {
        if (isDownloading()) {
            bTh();
        }
    }

    private void bTh() {
        if (this.gCH == null) {
            this.gCH = new d(this.mPageContext.getPageActivity());
            this.gCH.setProgress(0);
            this.gCH.mj(false);
        }
        if (this.gCH.bTe() != null && this.gCH.bTe().getParent() == null && this.gCE != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams.gravity = 5;
            this.gCE.a(this.gCH.bTe(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void bTi() {
        if (this.gCH != null && this.gCH.bTe() != null && this.gCH.bTe().getParent() != null) {
            ((ViewGroup) this.gCH.bTe().getParent()).removeView(this.gCH.bTe());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTj() {
        gCG = 0L;
        if (gCF != null) {
            gCF.apkStatusCallBack = null;
            gCF = null;
        }
        bTi();
        this.gCH = null;
    }

    public void cb(boolean z) {
        if (z && gCF != null) {
            ApkManager.getInstance().stopApkDownload(gCF);
            bTj();
        } else if (gCF != null) {
            gCF.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public boolean isDownloading() {
        return (gCG == 0 || gCF == null) ? false : true;
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
            gCF = apkData.m23clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m23clone(), false);
        } else if (a == ApkStatus.NONE || a == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && l.PM()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.gCm);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.gCm);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.i.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.gCm);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.gCm);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        gCF = apkData.m23clone();
        gCF.apkStatusCallBack = this.gCI;
        if (this.aAP != null && this.aAP.mLiveInfo != null) {
            gCG = this.aAP.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), gCF, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void GC(String str) {
        this.gCm = str;
    }

    public void setVisible(int i) {
        if (this.gCH != null && this.gCH.bTe() != null) {
            this.gCH.bTe().setVisibility(i);
        }
    }
}
