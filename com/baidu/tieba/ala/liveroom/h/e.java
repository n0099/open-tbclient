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
    private static ApkData fUu;
    private static long fUv = 0;
    private q aJj;
    private String fUe;
    private d fUw;
    private ApkStatusCallback fUx = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.h.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.bBq();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.fUw != null) {
                e.this.fUw.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.i.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.bBt();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.bBt();
        }
    };
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (fUu != null && fUv != 0) {
            fUu.apkStatusCallBack = this.fUx;
        }
    }

    public void a(q qVar, ViewGroup viewGroup) {
        this.aJj = qVar;
        this.mParentView = viewGroup;
        if (isDownloading() && qVar != null && qVar.mLiveInfo != null) {
            bBq();
            if (this.fUw != null) {
                if (qVar.mLiveInfo.live_id == fUv) {
                    this.fUw.kN(false);
                } else {
                    this.fUw.kN(true);
                }
            }
        }
    }

    public void bzV() {
        bBs();
    }

    public void bBp() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), fUu, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBq() {
        if (isDownloading()) {
            bBr();
        }
    }

    private void bBr() {
        if (this.fUw == null) {
            this.fUw = new d(this.mPageContext.getPageActivity());
            this.fUw.setProgress(0);
            this.fUw.kN(false);
        }
        if (this.fUw.getRootView() != null && this.fUw.getRootView().getParent() == null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
            if (this.mParentView instanceof PriorityVerticalLinearLayout) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
                layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
                layoutParams.gravity = 5;
                this.fUw.getRootView().setTag(a.g.sdk_pvl_layout_priority_tag_key, 23);
                this.mParentView.addView(this.fUw.getRootView(), layoutParams);
            }
        }
    }

    private void bBs() {
        if (this.fUw != null && this.fUw.getRootView() != null && this.fUw.getRootView().getParent() != null) {
            ((ViewGroup) this.fUw.getRootView().getParent()).removeView(this.fUw.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBt() {
        fUv = 0L;
        if (fUu != null) {
            fUu.apkStatusCallBack = null;
            fUu = null;
        }
        bBs();
        this.fUw = null;
    }

    public void bR(boolean z) {
        if (z && fUu != null) {
            ApkManager.getInstance().stopApkDownload(fUu);
            bBt();
        } else if (fUu != null) {
            fUu.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public boolean isDownloading() {
        return (fUv == 0 || fUu == null) ? false : true;
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
            fUu = apkData.m20clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m20clone(), false);
        } else if (a == ApkStatus.NONE || a == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && k.HX()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.fUe);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.fUe);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.i.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.fUe);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.fUe);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        fUu = apkData.m20clone();
        fUu.apkStatusCallBack = this.fUx;
        if (this.aJj != null && this.aJj.mLiveInfo != null) {
            fUv = this.aJj.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), fUu, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.h.f
    public void Cu(String str) {
        this.fUe = str;
    }

    public void setVisible(int i) {
        if (this.fUw != null && this.fUw.getRootView() != null) {
            this.fUw.getRootView().setVisibility(i);
        }
    }
}
