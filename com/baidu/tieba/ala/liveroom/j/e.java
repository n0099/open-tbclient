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
    private static ApkData hrR;
    private static long hrS = 0;
    private w aFN;
    private PendantParentView hrQ;
    private d hrT;
    private ApkStatusCallback hrU = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.j.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onJoinDownloadQueue() {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.cfn();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.hrT != null) {
                e.this.hrT.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.h.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.cfq();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.cfq();
        }
    };
    private String hrz;
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (hrR != null && hrS != 0) {
            hrR.apkStatusCallBack = this.hrU;
        }
    }

    public void b(w wVar, PendantParentView pendantParentView) {
        this.aFN = wVar;
        this.hrQ = pendantParentView;
        if (isDownloading() && wVar != null && wVar.mLiveInfo != null) {
            cfn();
            if (this.hrT != null) {
                if (wVar.mLiveInfo.live_id == hrS) {
                    this.hrT.nG(false);
                } else {
                    this.hrT.nG(true);
                }
            }
        }
    }

    public void cdm() {
        cfp();
    }

    public void cfm() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hrR, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfn() {
        if (isDownloading()) {
            cfo();
        }
    }

    private void cfo() {
        if (this.hrT == null) {
            this.hrT = new d(this.mPageContext.getPageActivity());
            this.hrT.setProgress(0);
            this.hrT.nG(false);
        }
        if (this.hrT.cfl() != null && this.hrT.cfl().getParent() == null && this.hrQ != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams.gravity = 5;
            this.hrQ.a(this.hrT.cfl(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void cfp() {
        if (this.hrT != null && this.hrT.cfl() != null && this.hrT.cfl().getParent() != null) {
            ((ViewGroup) this.hrT.cfl().getParent()).removeView(this.hrT.cfl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfq() {
        hrS = 0L;
        if (hrR != null) {
            hrR.apkStatusCallBack = null;
            hrR = null;
        }
        cfp();
        this.hrT = null;
    }

    public void cx(boolean z) {
        if (z && hrR != null) {
            ApkManager.getInstance().stopApkDownload(hrR);
            cfq();
        } else if (hrR != null) {
            hrR.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public boolean isDownloading() {
        return (hrS == 0 || hrR == null) ? false : true;
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
            hrR = apkData.m21clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m21clone(), false);
        } else if (b == ApkStatus.NONE || b == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && l.Ww()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hrz);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.hrz);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.h.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hrz);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.hrz);
                return;
            }
            a(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApkData apkData) {
        hrR = apkData.m21clone();
        hrR.apkStatusCallBack = this.hrU;
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            hrS = this.aFN.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hrR, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void It(String str) {
        this.hrz = str;
    }

    public void setVisible(int i) {
        if (this.hrT != null && this.hrT.cfl() != null) {
            this.hrT.cfl().setVisibility(i);
        }
    }
}
