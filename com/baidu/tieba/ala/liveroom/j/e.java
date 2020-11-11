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
    private static ApkData hiH;
    private static long hiI = 0;
    private w aES;
    private PendantParentView hiG;
    private d hiJ;
    private ApkStatusCallback hiK = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.j.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.cca();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.hiJ != null) {
                e.this.hiJ.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.h.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.ccd();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.ccd();
        }
    };
    private String hio;
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (hiH != null && hiI != 0) {
            hiH.apkStatusCallBack = this.hiK;
        }
    }

    public void b(w wVar, PendantParentView pendantParentView) {
        this.aES = wVar;
        this.hiG = pendantParentView;
        if (isDownloading() && wVar != null && wVar.mLiveInfo != null) {
            cca();
            if (this.hiJ != null) {
                if (wVar.mLiveInfo.live_id == hiI) {
                    this.hiJ.nk(false);
                } else {
                    this.hiJ.nk(true);
                }
            }
        }
    }

    public void bZX() {
        ccc();
    }

    public void cbZ() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hiH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cca() {
        if (isDownloading()) {
            ccb();
        }
    }

    private void ccb() {
        if (this.hiJ == null) {
            this.hiJ = new d(this.mPageContext.getPageActivity());
            this.hiJ.setProgress(0);
            this.hiJ.nk(false);
        }
        if (this.hiJ.cbY() != null && this.hiJ.cbY().getParent() == null && this.hiG != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams.gravity = 5;
            this.hiG.a(this.hiJ.cbY(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void ccc() {
        if (this.hiJ != null && this.hiJ.cbY() != null && this.hiJ.cbY().getParent() != null) {
            ((ViewGroup) this.hiJ.cbY().getParent()).removeView(this.hiJ.cbY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccd() {
        hiI = 0L;
        if (hiH != null) {
            hiH.apkStatusCallBack = null;
            hiH = null;
        }
        ccc();
        this.hiJ = null;
    }

    public void ch(boolean z) {
        if (z && hiH != null) {
            ApkManager.getInstance().stopApkDownload(hiH);
            ccd();
        } else if (hiH != null) {
            hiH.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public boolean isDownloading() {
        return (hiI == 0 || hiH == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public ApkStatus a(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void b(final ApkData apkData) {
        ApkStatus a2 = a(apkData);
        if (a2 == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m23clone());
        } else if (a2 == ApkStatus.DOWNLOADED) {
            hiH = apkData.m23clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m23clone(), false);
        } else if (a2 == ApkStatus.NONE || a2 == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && l.UF()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hio);
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
                        e.this.c(apkData);
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.hio);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.h.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hio);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.hio);
                return;
            }
            c(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkData apkData) {
        hiH = apkData.m23clone();
        hiH.apkStatusCallBack = this.hiK;
        if (this.aES != null && this.aES.mLiveInfo != null) {
            hiI = this.aES.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hiH, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void Ie(String str) {
        this.hio = str;
    }

    public void setVisible(int i) {
        if (this.hiJ != null && this.hiJ.cbY() != null) {
            this.hiJ.cbY().setVisibility(i);
        }
    }
}
