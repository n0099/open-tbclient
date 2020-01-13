package com.baidu.tieba.ala.liveroom.i;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkManager;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.apk.ApkStatusCallback;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.k;
import com.baidu.live.view.PriorityVerticalLinearLayout;
/* loaded from: classes2.dex */
public class e implements f {
    private static ApkData eXQ;
    private static long eXR = 0;
    private l aiW;
    private String eXA;
    private d eXS;
    private ApkStatusCallback eXT = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.i.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.bkh();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.eXS != null) {
                e.this.eXS.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.i.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.bkk();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.bkk();
        }
    };
    private TbPageContext mPageContext;
    private ViewGroup mParentView;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (eXQ != null && eXR != 0) {
            eXQ.apkStatusCallBack = this.eXT;
        }
    }

    public void a(l lVar, ViewGroup viewGroup) {
        this.aiW = lVar;
        this.mParentView = viewGroup;
        if (isDownloading() && lVar != null && lVar.mLiveInfo != null) {
            bkh();
            if (this.eXS != null) {
                if (lVar.mLiveInfo.live_id == eXR) {
                    this.eXS.jm(false);
                } else {
                    this.eXS.jm(true);
                }
            }
        }
    }

    public void biH() {
        bkj();
    }

    public void bkg() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), eXQ, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkh() {
        if (isDownloading()) {
            bki();
        }
    }

    private void bki() {
        if (this.eXS == null) {
            this.eXS = new d(this.mPageContext.getPageActivity());
            this.eXS.setProgress(0);
            this.eXS.jm(false);
        }
        if (this.eXS.getRootView() != null && this.eXS.getRootView().getParent() == null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100);
            if (this.mParentView instanceof PriorityVerticalLinearLayout) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
                layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds54);
                layoutParams.gravity = 5;
                this.eXS.getRootView().setTag(a.g.sdk_pvl_layout_priority_tag_key, 22);
                this.mParentView.addView(this.eXS.getRootView(), layoutParams);
            }
        }
    }

    private void bkj() {
        if (this.eXS != null && this.eXS.getRootView() != null && this.eXS.getRootView().getParent() != null) {
            ((ViewGroup) this.eXS.getRootView().getParent()).removeView(this.eXS.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkk() {
        eXR = 0L;
        if (eXQ != null) {
            eXQ.apkStatusCallBack = null;
            eXQ = null;
        }
        bkj();
        this.eXS = null;
    }

    public void jn(boolean z) {
        if (z && eXQ != null) {
            ApkManager.getInstance().stopApkDownload(eXQ);
            bkk();
        } else if (eXQ != null) {
            eXQ.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public boolean isDownloading() {
        return (eXR == 0 || eXQ == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public ApkStatus a(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public void b(final ApkData apkData) {
        ApkStatus a = a(apkData);
        if (a == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m16clone());
        } else if (a == ApkStatus.DOWNLOADED) {
            eXQ = apkData.m16clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m16clone(), false);
        } else if (a == ApkStatus.NONE || a == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && k.yH()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.eXA);
                            dialogInterface.dismiss();
                            return true;
                        }
                        return false;
                    }
                });
                bdAlertDialog.setCanceledOnTouchOutside(false);
                bdAlertDialog.setTitle(this.mPageContext.getResources().getString(a.i.ala_feedback_flow_download_net_title));
                bdAlertDialog.setMessage(this.mPageContext.getResources().getString(a.i.ala_feedback_flow_download_net_tip));
                bdAlertDialog.setPositiveButton(this.mPageContext.getResources().getString(a.i.sdk_go_on), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.3
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        e.this.c(apkData);
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.eXA);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.i.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.eXA);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.eXA);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        eXQ = apkData.m16clone();
        eXQ.apkStatusCallBack = this.eXT;
        if (this.aiW != null && this.aiW.mLiveInfo != null) {
            eXR = this.aiW.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), eXQ, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public void yG(String str) {
        this.eXA = str;
    }
}
