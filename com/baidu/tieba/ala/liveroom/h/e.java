package com.baidu.tieba.ala.liveroom.h;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.n;
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
    private static long fGA = 0;
    private static ApkData fGz;
    private n aDK;
    private d fGB;
    private ApkStatusCallback fGC = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.h.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.bvr();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.fGB != null) {
                e.this.fGB.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.i.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.bvu();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.bvu();
        }
    };
    private String fGj;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (fGz != null && fGA != 0) {
            fGz.apkStatusCallBack = this.fGC;
        }
    }

    public void a(n nVar, ViewGroup viewGroup) {
        this.aDK = nVar;
        this.mParentView = viewGroup;
        if (isDownloading() && nVar != null && nVar.mLiveInfo != null) {
            bvr();
            if (this.fGB != null) {
                if (nVar.mLiveInfo.live_id == fGA) {
                    this.fGB.ks(false);
                } else {
                    this.fGB.ks(true);
                }
            }
        }
    }

    public void btW() {
        bvt();
    }

    public void bvq() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), fGz, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvr() {
        if (isDownloading()) {
            bvs();
        }
    }

    private void bvs() {
        if (this.fGB == null) {
            this.fGB = new d(this.mPageContext.getPageActivity());
            this.fGB.setProgress(0);
            this.fGB.ks(false);
        }
        if (this.fGB.getRootView() != null && this.fGB.getRootView().getParent() == null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
            if (this.mParentView instanceof PriorityVerticalLinearLayout) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
                layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
                layoutParams.gravity = 5;
                this.fGB.getRootView().setTag(a.g.sdk_pvl_layout_priority_tag_key, 23);
                this.mParentView.addView(this.fGB.getRootView(), layoutParams);
            }
        }
    }

    private void bvt() {
        if (this.fGB != null && this.fGB.getRootView() != null && this.fGB.getRootView().getParent() != null) {
            ((ViewGroup) this.fGB.getRootView().getParent()).removeView(this.fGB.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvu() {
        fGA = 0L;
        if (fGz != null) {
            fGz.apkStatusCallBack = null;
            fGz = null;
        }
        bvt();
        this.fGB = null;
    }

    public void bI(boolean z) {
        if (z && fGz != null) {
            ApkManager.getInstance().stopApkDownload(fGz);
            bvu();
        } else if (fGz != null) {
            fGz.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public boolean isDownloading() {
        return (fGA == 0 || fGz == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public ApkStatus a(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public void b(final ApkData apkData) {
        ApkStatus a = a(apkData);
        if (a == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m21clone());
        } else if (a == ApkStatus.DOWNLOADED) {
            fGz = apkData.m21clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m21clone(), false);
        } else if (a == ApkStatus.NONE || a == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && k.Ge()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.fGj);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.fGj);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.i.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.fGj);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.fGj);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        fGz = apkData.m21clone();
        fGz.apkStatusCallBack = this.fGC;
        if (this.aDK != null && this.aDK.mLiveInfo != null) {
            fGA = this.aDK.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), fGz, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public void AM(String str) {
        this.fGj = str;
    }

    public void setVisible(int i) {
        if (this.fGB != null && this.fGB.getRootView() != null) {
            this.fGB.getRootView().setVisibility(i);
        }
    }
}
