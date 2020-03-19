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
    private static ApkData fcl;
    private static long fcm = 0;
    private m alp;
    private String fbV;
    private d fcn;
    private ApkStatusCallback fco = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.h.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.bmd();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.fcn != null) {
                e.this.fcn.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.i.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.bmg();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.bmg();
        }
    };
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (fcl != null && fcm != 0) {
            fcl.apkStatusCallBack = this.fco;
        }
    }

    public void a(m mVar, ViewGroup viewGroup) {
        this.alp = mVar;
        this.mParentView = viewGroup;
        if (isDownloading() && mVar != null && mVar.mLiveInfo != null) {
            bmd();
            if (this.fcn != null) {
                if (mVar.mLiveInfo.live_id == fcm) {
                    this.fcn.jr(false);
                } else {
                    this.fcn.jr(true);
                }
            }
        }
    }

    public void bkF() {
        bmf();
    }

    public void bmc() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), fcl, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmd() {
        if (isDownloading()) {
            bme();
        }
    }

    private void bme() {
        if (this.fcn == null) {
            this.fcn = new d(this.mPageContext.getPageActivity());
            this.fcn.setProgress(0);
            this.fcn.jr(false);
        }
        if (this.fcn.getRootView() != null && this.fcn.getRootView().getParent() == null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
            if (this.mParentView instanceof PriorityVerticalLinearLayout) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
                layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
                layoutParams.gravity = 5;
                this.fcn.getRootView().setTag(a.g.sdk_pvl_layout_priority_tag_key, 23);
                this.mParentView.addView(this.fcn.getRootView(), layoutParams);
            }
        }
    }

    private void bmf() {
        if (this.fcn != null && this.fcn.getRootView() != null && this.fcn.getRootView().getParent() != null) {
            ((ViewGroup) this.fcn.getRootView().getParent()).removeView(this.fcn.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmg() {
        fcm = 0L;
        if (fcl != null) {
            fcl.apkStatusCallBack = null;
            fcl = null;
        }
        bmf();
        this.fcn = null;
    }

    public void be(boolean z) {
        if (z && fcl != null) {
            ApkManager.getInstance().stopApkDownload(fcl);
            bmg();
        } else if (fcl != null) {
            fcl.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public boolean isDownloading() {
        return (fcm == 0 || fcl == null) ? false : true;
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
            fcl = apkData.m20clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m20clone(), false);
        } else if (a == ApkStatus.NONE || a == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && k.Bh()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.fbV);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.fbV);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.i.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.fbV);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.fbV);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        fcl = apkData.m20clone();
        fcl.apkStatusCallBack = this.fco;
        if (this.alp != null && this.alp.mLiveInfo != null) {
            fcm = this.alp.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), fcl, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public void zc(String str) {
        this.fbV = str;
    }

    public void setVisible(int i) {
        if (this.fcn != null && this.fcn.getRootView() != null) {
            this.fcn.getRootView().setVisibility(i);
        }
    }
}
