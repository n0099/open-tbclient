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
    private static ApkData hrP;
    private static long hrQ = 0;
    private w aFN;
    private PendantParentView hrO;
    private d hrR;
    private ApkStatusCallback hrS = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.j.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onJoinDownloadQueue() {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.cfm();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.hrR != null) {
                e.this.hrR.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.h.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.cfp();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.cfp();
        }
    };
    private String hrx;
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (hrP != null && hrQ != 0) {
            hrP.apkStatusCallBack = this.hrS;
        }
    }

    public void b(w wVar, PendantParentView pendantParentView) {
        this.aFN = wVar;
        this.hrO = pendantParentView;
        if (isDownloading() && wVar != null && wVar.mLiveInfo != null) {
            cfm();
            if (this.hrR != null) {
                if (wVar.mLiveInfo.live_id == hrQ) {
                    this.hrR.nG(false);
                } else {
                    this.hrR.nG(true);
                }
            }
        }
    }

    public void cdl() {
        cfo();
    }

    public void cfl() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hrP, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfm() {
        if (isDownloading()) {
            cfn();
        }
    }

    private void cfn() {
        if (this.hrR == null) {
            this.hrR = new d(this.mPageContext.getPageActivity());
            this.hrR.setProgress(0);
            this.hrR.nG(false);
        }
        if (this.hrR.cfk() != null && this.hrR.cfk().getParent() == null && this.hrO != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams.gravity = 5;
            this.hrO.a(this.hrR.cfk(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void cfo() {
        if (this.hrR != null && this.hrR.cfk() != null && this.hrR.cfk().getParent() != null) {
            ((ViewGroup) this.hrR.cfk().getParent()).removeView(this.hrR.cfk());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfp() {
        hrQ = 0L;
        if (hrP != null) {
            hrP.apkStatusCallBack = null;
            hrP = null;
        }
        cfo();
        this.hrR = null;
    }

    public void cx(boolean z) {
        if (z && hrP != null) {
            ApkManager.getInstance().stopApkDownload(hrP);
            cfp();
        } else if (hrP != null) {
            hrP.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public boolean isDownloading() {
        return (hrQ == 0 || hrP == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public ApkStatus b(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void c(final ApkData apkData) {
        ApkStatus b = b(apkData);
        if (b == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m21clone());
        } else if (b == ApkStatus.DOWNLOADED) {
            hrP = apkData.m21clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m21clone(), false);
        } else if (b == ApkStatus.NONE || b == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && l.Ww()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hrx);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.hrx);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.h.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hrx);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.hrx);
                return;
            }
            a(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApkData apkData) {
        hrP = apkData.m21clone();
        hrP.apkStatusCallBack = this.hrS;
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            hrQ = this.aFN.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hrP, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void It(String str) {
        this.hrx = str;
    }

    public void setVisible(int i) {
        if (this.hrR != null && this.hrR.cfk() != null) {
            this.hrR.cfk().setVisibility(i);
        }
    }
}
