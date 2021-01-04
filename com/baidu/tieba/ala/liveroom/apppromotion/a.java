package com.baidu.tieba.ala.liveroom.apppromotion;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import com.baidu.live.data.d;
import com.baidu.live.data.x;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkManager;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.apk.ApkStatusCallback;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.c.a {
    private d aKU;
    private PendantParentView hqe;
    private PendantChildView hqf;
    private AlaAppPromotionView hqg;
    private ApkData hqh;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.c.a
    public void b(ViewGroup viewGroup, x xVar) {
        resetView();
        if (xVar == null || xVar.aKU == null) {
            this.aKU = null;
            this.hqg = null;
            return;
        }
        this.aKU = xVar.aKU;
        if (viewGroup instanceof PendantParentView) {
            this.hqe = (PendantParentView) viewGroup;
        }
        D(xVar);
    }

    private void D(x xVar) {
        if (this.aKU.Et() && ccO()) {
            this.hqh = a(this.aKU);
            E(xVar);
            ccL();
            F(xVar);
        }
    }

    private void ccL() {
        String string;
        if (this.hqg != null) {
            if (!TextUtils.isEmpty(this.aKU.icon) || !TextUtils.isEmpty(this.aKU.des)) {
                this.hqg.setImage(this.aKU.icon);
                ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hqh);
                if (apkStatus == ApkStatus.READY) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_open, this.aKU.des);
                } else if (apkStatus == ApkStatus.DOWNLOADED) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded);
                } else {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, this.aKU.des);
                    if (ApkManager.getInstance().isDownloading(this.hqh)) {
                        ccN();
                    }
                }
                this.hqg.setStatus(string);
            }
        }
    }

    private void resetView() {
        if (this.hqg != null && (this.hqg.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hqg.getParent()).removeView(this.hqg);
        }
        if (this.hqf != null && (this.hqf.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hqf.getParent()).removeView(this.hqf);
        }
    }

    @Override // com.baidu.live.c.a
    public void setCanVisible(boolean z) {
        if (this.hqg != null) {
            if (z) {
                this.hqg.setVisibility(0);
            } else {
                this.hqg.setVisibility(4);
            }
        }
    }

    private ApkData a(d dVar) {
        ApkData apkData = new ApkData();
        apkData.apkPackageName = dVar.packageName;
        apkData.apkDeeplinkScheme = dVar.aJg;
        apkData.apkUrl = dVar.downloadUrl;
        apkData.apkStatusCallBack = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.1
            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onJoinDownloadQueue() {
                if (a.this.hqg != null && a.this.hqg.getParent() != null && a.this.mPageContext != null) {
                    a.this.hqg.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download_ready));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadStart(ApkData apkData2) {
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadProgress(long j, long j2) {
                if (a.this.hqg != null && a.this.hqg.getParent() != null) {
                    a.this.hqg.setProgress(j, j2);
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadSucceed(ApkData apkData2) {
                if (a.this.hqg != null && a.this.hqg.getParent() != null && a.this.mPageContext != null) {
                    a.this.hqg.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadFailed(ApkData apkData2, int i, String str) {
                if (a.this.hqg != null && a.this.hqg.getParent() != null && a.this.mPageContext != null) {
                    a.this.hqg.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, a.this.aKU.des));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkStartInstall(ApkData apkData2) {
            }
        };
        return apkData;
    }

    private void E(final x xVar) {
        if (this.hqf == null) {
            this.hqf = new PendantChildView(this.mPageContext.getPageActivity()) { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.2
                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalPkPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalBBChattingPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getHorizontalPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getHorizontalFullPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public int getPriority() {
                    if (this.byd == PendantParentView.Model.VERTICAL) {
                        return 91;
                    }
                    if (this.byd == PendantParentView.Model.VERTICAL_PK) {
                        return 99;
                    }
                    return 104;
                }
            };
            this.hqf.setBackgroundColor(0);
            this.hqf.setId(a.f.ala_pendant_app_promotion);
        }
        if (this.hqe != null && this.hqe.indexOfChild(this.hqf) < 0) {
            this.hqe.a(this.hqf, new LinearLayout.LayoutParams(-2, -2));
        }
        if (this.hqg == null) {
            this.hqg = new AlaAppPromotionView(this.mPageContext.getPageActivity());
            this.hqg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.G(xVar);
                    a.this.ccM();
                }
            });
        }
        if (this.hqf.indexOfChild(this.hqg) < 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            this.hqf.addView(this.hqg, layoutParams);
        }
        this.hqf.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccM() {
        ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hqh);
        if (apkStatus == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), this.hqh);
        } else if (apkStatus == ApkStatus.DOWNLOADED) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.hqh, false);
        } else {
            a(this.hqh);
        }
    }

    private void a(ApkData apkData) {
        if (apkData != null) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.hqh, true);
        }
    }

    private void ccN() {
        ApkManager.getInstance().addFileDownloadCallback(this.hqh, this.mPageContext.getPageActivity());
    }

    @Override // com.baidu.live.c.a
    public void Bf() {
        ApkManager.getInstance().removeFileDownloadCallback(this.hqh);
        resetView();
    }

    @Override // com.baidu.live.c.a
    public void onStart() {
        ccL();
    }

    @Override // com.baidu.live.c.a
    public void onDestroy() {
        resetView();
    }

    private boolean ccO() {
        if (Build.VERSION.SDK_INT >= 24) {
            return (TextUtils.isEmpty(TbConfig.FILE_PROVIDER_AUTHORITIES) || TextUtils.isEmpty(TbConfig.FILE_OUTPUT_FILE_ROOT_PATH)) ? false : true;
        }
        return true;
    }

    private void F(x xVar) {
        String str;
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hqh) == ApkStatus.READY) {
            str = NotificationCompat.CATEGORY_CALL;
        } else {
            str = "new";
        }
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "guidepop_show");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("live_id", xVar.mLiveInfo.live_id);
            jSONObject.put("vid", xVar.mLiveInfo.feed_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt("", "guidepop", str, jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(x xVar) {
        String str;
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hqh) == ApkStatus.READY) {
            str = NotificationCompat.CATEGORY_CALL;
        } else {
            str = "new";
        }
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "guidepop_clk");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("live_id", xVar.mLiveInfo.live_id);
            jSONObject.put("vid", xVar.mLiveInfo.feed_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt("", "guidepop", str, jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }
}
