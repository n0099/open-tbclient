package com.baidu.tieba.ala.liveroom.j;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.x;
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
    private static ApkData hDM;
    private static long hDN = 0;
    private x aGe;
    private PendantParentView hDL;
    private d hDO;
    private ApkStatusCallback hDP = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.j.e.1
        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onJoinDownloadQueue() {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadStart(ApkData apkData) {
            e.this.cie();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadProgress(long j, long j2) {
            if (e.this.hDO != null) {
                e.this.hDO.setProgress((int) ((100 * j) / j2));
            }
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadSucceed(ApkData apkData) {
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkDownloadFailed(ApkData apkData, int i, String str) {
            e.this.mPageContext.showToast(e.this.mPageContext.getString(a.h.ala_feedback_flow_download_fail_tip_prefix) + str);
            e.this.cih();
        }

        @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
        public void onApkStartInstall(ApkData apkData) {
            e.this.cih();
        }
    };
    private String hDv;
    private TbPageContext mPageContext;
    private long roomId;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (hDM != null && hDN != 0) {
            hDM.apkStatusCallBack = this.hDP;
        }
    }

    public void b(x xVar, PendantParentView pendantParentView) {
        this.aGe = xVar;
        this.hDL = pendantParentView;
        if (isDownloading() && xVar != null && xVar.mLiveInfo != null) {
            cie();
            if (this.hDO != null) {
                if (xVar.mLiveInfo.live_id == hDN) {
                    this.hDO.og(false);
                } else {
                    this.hDO.og(true);
                }
            }
        }
    }

    public void cgd() {
        cig();
    }

    public void cid() {
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hDM, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cie() {
        if (isDownloading()) {
            cif();
        }
    }

    private void cif() {
        if (this.hDO == null) {
            this.hDO = new d(this.mPageContext.getPageActivity());
            this.hDO.setProgress(0);
            this.hDO.og(false);
        }
        if (this.hDO.cic() != null && this.hDO.cic().getParent() == null && this.hDL != null) {
            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds54);
            layoutParams.gravity = 5;
            this.hDL.a(this.hDO.cic(), new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void cig() {
        if (this.hDO != null && this.hDO.cic() != null && this.hDO.cic().getParent() != null) {
            ((ViewGroup) this.hDO.cic().getParent()).removeView(this.hDO.cic());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cih() {
        hDN = 0L;
        if (hDM != null) {
            hDM.apkStatusCallBack = null;
            hDM = null;
        }
        cig();
        this.hDO = null;
    }

    public void cA(boolean z) {
        if (z && hDM != null) {
            ApkManager.getInstance().stopApkDownload(hDM);
            cih();
        } else if (hDM != null) {
            hDM.apkStatusCallBack = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public boolean isDownloading() {
        return (hDN == 0 || hDM == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public ApkStatus b(ApkData apkData) {
        return ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), apkData);
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void c(final ApkData apkData) {
        ApkStatus b2 = b(apkData);
        if (b2 == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), apkData.m22clone());
        } else if (b2 == ApkStatus.DOWNLOADED) {
            hDM = apkData.m22clone();
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), apkData.m22clone(), false);
        } else if (b2 == ApkStatus.NONE || b2 == ApkStatus.OVERTIME) {
            if (BdNetTypeUtil.isMobileNet() && m.XB()) {
                BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                bdAlertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hDv);
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
                        LogManager.getFeedDiversionLogger().doContinueFlowDialogLog(e.this.roomId + "", e.this.hDv);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNegativeButton(this.mPageContext.getResources().getString(a.h.sdk_stop), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.e.4
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        LogManager.getFeedDiversionLogger().doStopFlowDialogLog(e.this.roomId + "", e.this.hDv);
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
                bdAlertDialog.create(this.mPageContext);
                bdAlertDialog.show();
                LogManager.getFeedDiversionLogger().doDisplayFlowDialogLog(this.roomId + "", this.hDv);
                return;
            }
            a(apkData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApkData apkData) {
        hDM = apkData.m22clone();
        hDM.apkStatusCallBack = this.hDP;
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            hDN = this.aGe.mLiveInfo.live_id;
        }
        ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), hDM, true);
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    @Override // com.baidu.tieba.ala.liveroom.j.f
    public void Iu(String str) {
        this.hDv = str;
    }

    public void setVisible(int i) {
        if (this.hDO != null && this.hDO.cic() != null) {
            this.hDO.cic().setVisibility(i);
        }
    }
}
