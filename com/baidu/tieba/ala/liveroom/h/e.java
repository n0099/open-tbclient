package com.baidu.tieba.ala.liveroom.h;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkManager;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.apk.ApkStatusCallback;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.live.view.PriorityVerticalLinearLayout;
/* loaded from: classes3.dex */
public class e implements f {
    private static long fbA = 0;
    private static ApkData fbz;
    private m ald;
    private d fbB;
    private ApkStatusCallback fbC = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.h.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.blV();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.fbB != null) {
                e.this.fbB.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.i.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.blY();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.blY();
        }
    };
    private String fbj;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (fbz != null && fbA != 0) {
            fbz.apkStatusCallBack = this.fbC;
        }
    }

    public void a(m mVar, ViewGroup viewGroup) {
        this.ald = mVar;
        this.mParentView = viewGroup;
        if (isDownloading() && mVar != null && mVar.mLiveInfo != null) {
            blV();
            if (this.fbB != null) {
                if (mVar.mLiveInfo.live_id == fbA) {
                    this.fbB.jp(false);
                } else {
                    this.fbB.jp(true);
                }
            }
        }
    }

    public void bkx() {
        blX();
    }

    public void blU() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), fbz, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blV() {
        if (isDownloading()) {
            blW();
        }
    }

    private void blW() {
        if (this.fbB == null) {
            this.fbB = new d(this.mPageContext.getPageActivity());
            this.fbB.setProgress(0);
            this.fbB.jp(false);
        }
        if (this.fbB.getRootView() != null && this.fbB.getRootView().getParent() == null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
            if (this.mParentView instanceof PriorityVerticalLinearLayout) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
                layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
                layoutParams.gravity = 5;
                this.fbB.getRootView().setTag(a.g.sdk_pvl_layout_priority_tag_key, 23);
                this.mParentView.addView(this.fbB.getRootView(), layoutParams);
            }
        }
    }

    private void blX() {
        if (this.fbB != null && this.fbB.getRootView() != null && this.fbB.getRootView().getParent() != null) {
            ((ViewGroup) this.fbB.getRootView().getParent()).removeView(this.fbB.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blY() {
        fbA = 0L;
        if (fbz != null) {
            fbz.apkStatusCallBack = null;
            fbz = null;
        }
        blX();
        this.fbB = null;
    }

    public void be(boolean z) {
        if (z && fbz != null) {
            ApkManager.getInstance().stopApkDownload(fbz);
            blY();
        } else if (fbz != null) {
            fbz.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public boolean isDownloading() {
        return (fbA == 0 || fbz == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public ApkStatus a(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public void b(final ApkData apkData) {
        ApkStatus a = a(apkData);
        if (a == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m20clone());
        } else if (a == ApkStatus.DOWNLOADED) {
            fbz = apkData.m20clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m20clone(), false);
        } else if (a == ApkStatus.NONE || a == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && k.AY()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.fbj);
                            dialogInterface.dismiss();
                            return true;
                        }
                        return false;
                    }
                });
                bdAlertDialog.setCanceledOnTouchOutside(false);
                bdAlertDialog.setTitle(this.mPageContext.getResources().getString(a.i.ala_feedback_flow_download_net_title));
                bdAlertDialog.setMessage(this.mPageContext.getResources().getString(a.i.ala_feedback_flow_download_net_tip));
                bdAlertDialog.setPositiveButton(this.mPageContext.getResources().getString(a.i.sdk_go_on), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.3
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        e.this.c(apkData);
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.fbj);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.i.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.fbj);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.fbj);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        fbz = apkData.m20clone();
        fbz.apkStatusCallBack = this.fbC;
        if (this.ald != null && this.ald.mLiveInfo != null) {
            fbA = this.ald.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), fbz, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public void za(String str) {
        this.fbj = str;
    }

    public void setVisible(int i) {
        if (this.fbB != null && this.fbB.getRootView() != null) {
            this.fbB.getRootView().setVisibility(i);
        }
    }
}
