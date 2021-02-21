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
    private static ApkData hDF;
    private static long hDG = 0;
    private ab aDd;
    private PendantParentView hDE;
    private d hDH;
    private ApkStatusCallback hDI = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.i.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onJoinDownloadQueue() {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.cfo();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.hDH != null) {
                e.this.hDH.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.h.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.cfr();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.cfr();
        }
    };
    private String hDo;
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (hDF != null && hDG != 0) {
            hDF.apkStatusCallBack = this.hDI;
        }
    }

    public void b(ab abVar, PendantParentView pendantParentView) {
        this.aDd = abVar;
        this.hDE = pendantParentView;
        if (isDownloading() && abVar != null && abVar.mLiveInfo != null) {
            cfo();
            if (this.hDH != null) {
                if (abVar.mLiveInfo.live_id == hDG) {
                    this.hDH.on(false);
                } else {
                    this.hDH.on(true);
                }
            }
        }
    }

    public void cdn() {
        cfq();
    }

    public void cfn() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hDF, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfo() {
        if (isDownloading()) {
            cfp();
        }
    }

    private void cfp() {
        if (this.hDH == null) {
            this.hDH = new d(this.mPageContext.getPageActivity());
            this.hDH.setProgress(0);
            this.hDH.on(false);
        }
        if (this.hDH.cfm() != null && this.hDH.cfm().getParent() == null && this.hDE != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams.gravity = 5;
            this.hDE.a(this.hDH.cfm(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void cfq() {
        if (this.hDH != null && this.hDH.cfm() != null && this.hDH.cfm().getParent() != null) {
            ((ViewGroup) this.hDH.cfm().getParent()).removeView(this.hDH.cfm());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfr() {
        hDG = 0L;
        if (hDF != null) {
            hDF.apkStatusCallBack = null;
            hDF = null;
        }
        cfq();
        this.hDH = null;
    }

    public void cF(boolean z) {
        if (z && hDF != null) {
            ApkManager.getInstance().stopApkDownload(hDF);
            cfr();
        } else if (hDF != null) {
            hDF.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public boolean isDownloading() {
        return (hDG == 0 || hDF == null) ? false : true;
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
            hDF = apkData.m20clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m20clone(), false);
        } else if (b2 == ApkStatus.NONE || b2 == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && m.Vp()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hDo);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.hDo);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.h.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hDo);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.hDo);
                return;
            }
            a(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApkData apkData) {
        hDF = apkData.m20clone();
        hDF.apkStatusCallBack = this.hDI;
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            hDG = this.aDd.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hDF, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.i.f
    public void HO(String str) {
        this.hDo = str;
    }

    public void setVisible(int i) {
        if (this.hDH != null && this.hDH.cfm() != null) {
            this.hDH.cfm().setVisibility(i);
        }
    }
}
