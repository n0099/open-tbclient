package com.baidu.tieba.ala.liveroom.j;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.w;
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
    private static ApkData hcL;
    private static long hcM = 0;
    private w aEc;
    private PendantParentView hcK;
    private d hcN;
    private ApkStatusCallback hcO = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.j.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.bZy();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.hcN != null) {
                e.this.hcN.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.i.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.bZB();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.bZB();
        }
    };
    private String hcs;
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (hcL != null && hcM != 0) {
            hcL.apkStatusCallBack = this.hcO;
        }
    }

    public void b(w wVar, PendantParentView pendantParentView) {
        this.aEc = wVar;
        this.hcK = pendantParentView;
        if (isDownloading() && wVar != null && wVar.mLiveInfo != null) {
            bZy();
            if (this.hcN != null) {
                if (wVar.mLiveInfo.live_id == hcM) {
                    this.hcN.nb(false);
                } else {
                    this.hcN.nb(true);
                }
            }
        }
    }

    public void bXv() {
        bZA();
    }

    public void bZx() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hcL, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZy() {
        if (isDownloading()) {
            bZz();
        }
    }

    private void bZz() {
        if (this.hcN == null) {
            this.hcN = new d(this.mPageContext.getPageActivity());
            this.hcN.setProgress(0);
            this.hcN.nb(false);
        }
        if (this.hcN.bZw() != null && this.hcN.bZw().getParent() == null && this.hcK != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
            layoutParams.gravity = 5;
            this.hcK.a(this.hcN.bZw(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void bZA() {
        if (this.hcN != null && this.hcN.bZw() != null && this.hcN.bZw().getParent() != null) {
            ((ViewGroup) this.hcN.bZw().getParent()).removeView(this.hcN.bZw());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZB() {
        hcM = 0L;
        if (hcL != null) {
            hcL.apkStatusCallBack = null;
            hcL = null;
        }
        bZA();
        this.hcN = null;
    }

    public void cg(boolean z) {
        if (z && hcL != null) {
            ApkManager.getInstance().stopApkDownload(hcL);
            bZB();
        } else if (hcL != null) {
            hcL.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public boolean isDownloading() {
        return (hcM == 0 || hcL == null) ? false : true;
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
            hcL = apkData.m22clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m22clone(), false);
        } else if (a2 == ApkStatus.NONE || a2 == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && l.RX()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hcs);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.hcs);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.i.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hcs);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.hcs);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        hcL = apkData.m22clone();
        hcL.apkStatusCallBack = this.hcO;
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            hcM = this.aEc.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hcL, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void HN(String str) {
        this.hcs = str;
    }

    public void setVisible(int i) {
        if (this.hcN != null && this.hcN.bZw() != null) {
            this.hcN.bZw().setVisibility(i);
        }
    }
}
