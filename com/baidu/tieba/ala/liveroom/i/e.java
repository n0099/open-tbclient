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
/* loaded from: classes11.dex */
public class e implements f {
    private static ApkData hDr;
    private static long hDs = 0;
    private ab aDd;
    private String hDa;
    private PendantParentView hDq;
    private d hDt;
    private ApkStatusCallback hDu = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.i.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onJoinDownloadQueue() {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.cfh();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.hDt != null) {
                e.this.hDt.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.h.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.cfk();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.cfk();
        }
    };
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (hDr != null && hDs != 0) {
            hDr.apkStatusCallBack = this.hDu;
        }
    }

    public void b(ab abVar, PendantParentView pendantParentView) {
        this.aDd = abVar;
        this.hDq = pendantParentView;
        if (isDownloading() && abVar != null && abVar.mLiveInfo != null) {
            cfh();
            if (this.hDt != null) {
                if (abVar.mLiveInfo.live_id == hDs) {
                    this.hDt.on(false);
                } else {
                    this.hDt.on(true);
                }
            }
        }
    }

    public void cdg() {
        cfj();
    }

    public void cfg() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hDr, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfh() {
        if (isDownloading()) {
            cfi();
        }
    }

    private void cfi() {
        if (this.hDt == null) {
            this.hDt = new d(this.mPageContext.getPageActivity());
            this.hDt.setProgress(0);
            this.hDt.on(false);
        }
        if (this.hDt.cff() != null && this.hDt.cff().getParent() == null && this.hDq != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams.gravity = 5;
            this.hDq.a(this.hDt.cff(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void cfj() {
        if (this.hDt != null && this.hDt.cff() != null && this.hDt.cff().getParent() != null) {
            ((ViewGroup) this.hDt.cff().getParent()).removeView(this.hDt.cff());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfk() {
        hDs = 0L;
        if (hDr != null) {
            hDr.apkStatusCallBack = null;
            hDr = null;
        }
        cfj();
        this.hDt = null;
    }

    public void cF(boolean z) {
        if (z && hDr != null) {
            ApkManager.getInstance().stopApkDownload(hDr);
            cfk();
        } else if (hDr != null) {
            hDr.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public boolean isDownloading() {
        return (hDs == 0 || hDr == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public ApkStatus b(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public void c(final ApkData apkData) {
        ApkStatus b2 = b(apkData);
        if (b2 == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m20clone());
        } else if (b2 == ApkStatus.DOWNLOADED) {
            hDr = apkData.m20clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m20clone(), false);
        } else if (b2 == ApkStatus.NONE || b2 == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && m.Vp()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hDa);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.hDa);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.h.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hDa);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.hDa);
                return;
            }
            a(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApkData apkData) {
        hDr = apkData.m20clone();
        hDr.apkStatusCallBack = this.hDu;
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            hDs = this.aDd.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hDr, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public void HN(String str) {
        this.hDa = str;
    }

    public void setVisible(int i) {
        if (this.hDt != null && this.hDt.cff() != null) {
            this.hDt.cff().setVisibility(i);
        }
    }
}
