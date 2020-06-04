package com.baidu.tieba.ala.liveroom.h;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.q;
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
    private static ApkData fUF;
    private static long fUG = 0;
    private q aJj;
    private d fUH;
    private ApkStatusCallback fUI = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.h.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.bBs();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.fUH != null) {
                e.this.fUH.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.i.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.bBv();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.bBv();
        }
    };
    private String fUp;
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (fUF != null && fUG != 0) {
            fUF.apkStatusCallBack = this.fUI;
        }
    }

    public void a(q qVar, ViewGroup viewGroup) {
        this.aJj = qVar;
        this.mParentView = viewGroup;
        if (isDownloading() && qVar != null && qVar.mLiveInfo != null) {
            bBs();
            if (this.fUH != null) {
                if (qVar.mLiveInfo.live_id == fUG) {
                    this.fUH.kN(false);
                } else {
                    this.fUH.kN(true);
                }
            }
        }
    }

    public void bzX() {
        bBu();
    }

    public void bBr() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), fUF, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBs() {
        if (isDownloading()) {
            bBt();
        }
    }

    private void bBt() {
        if (this.fUH == null) {
            this.fUH = new d(this.mPageContext.getPageActivity());
            this.fUH.setProgress(0);
            this.fUH.kN(false);
        }
        if (this.fUH.getRootView() != null && this.fUH.getRootView().getParent() == null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
            if (this.mParentView instanceof PriorityVerticalLinearLayout) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
                layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
                layoutParams.gravity = 5;
                this.fUH.getRootView().setTag(a.g.sdk_pvl_layout_priority_tag_key, 23);
                this.mParentView.addView(this.fUH.getRootView(), layoutParams);
            }
        }
    }

    private void bBu() {
        if (this.fUH != null && this.fUH.getRootView() != null && this.fUH.getRootView().getParent() != null) {
            ((ViewGroup) this.fUH.getRootView().getParent()).removeView(this.fUH.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBv() {
        fUG = 0L;
        if (fUF != null) {
            fUF.apkStatusCallBack = null;
            fUF = null;
        }
        bBu();
        this.fUH = null;
    }

    public void bR(boolean z) {
        if (z && fUF != null) {
            ApkManager.getInstance().stopApkDownload(fUF);
            bBv();
        } else if (fUF != null) {
            fUF.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public boolean isDownloading() {
        return (fUG == 0 || fUF == null) ? false : true;
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
            fUF = apkData.m20clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m20clone(), false);
        } else if (a == ApkStatus.NONE || a == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && k.HX()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.fUp);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.fUp);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.i.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.fUp);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.fUp);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        fUF = apkData.m20clone();
        fUF.apkStatusCallBack = this.fUI;
        if (this.aJj != null && this.aJj.mLiveInfo != null) {
            fUG = this.aJj.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), fUF, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public void Cu(String str) {
        this.fUp = str;
    }

    public void setVisible(int i) {
        if (this.fUH != null && this.fUH.getRootView() != null) {
            this.fUH.getRootView().setVisibility(i);
        }
    }
}
