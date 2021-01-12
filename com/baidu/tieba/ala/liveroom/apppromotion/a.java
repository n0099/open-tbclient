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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.c.a {
    private d aGh;
    private ApkData hlA;
    private PendantParentView hlx;
    private PendantChildView hly;
    private AlaAppPromotionView hlz;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.c.a
    public void b(ViewGroup viewGroup, x xVar) {
        resetView();
        if (xVar == null || xVar.aGh == null) {
            this.aGh = null;
            this.hlz = null;
            return;
        }
        this.aGh = xVar.aGh;
        if (viewGroup instanceof PendantParentView) {
            this.hlx = (PendantParentView) viewGroup;
        }
        D(xVar);
    }

    private void D(x xVar) {
        if (this.aGh.Ay() && bYX()) {
            this.hlA = a(this.aGh);
            E(xVar);
            bYU();
            F(xVar);
        }
    }

    private void bYU() {
        String string;
        if (this.hlz != null) {
            if (!TextUtils.isEmpty(this.aGh.icon) || !TextUtils.isEmpty(this.aGh.des)) {
                this.hlz.setImage(this.aGh.icon);
                ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hlA);
                if (apkStatus == ApkStatus.READY) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_open, this.aGh.des);
                } else if (apkStatus == ApkStatus.DOWNLOADED) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded);
                } else {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, this.aGh.des);
                    if (ApkManager.getInstance().isDownloading(this.hlA)) {
                        bYW();
                    }
                }
                this.hlz.setStatus(string);
            }
        }
    }

    private void resetView() {
        if (this.hlz != null && (this.hlz.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hlz.getParent()).removeView(this.hlz);
        }
        if (this.hly != null && (this.hly.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hly.getParent()).removeView(this.hly);
        }
    }

    @Override // com.baidu.live.c.a
    public void setCanVisible(boolean z) {
        if (this.hlz != null) {
            if (z) {
                this.hlz.setVisibility(0);
            } else {
                this.hlz.setVisibility(4);
            }
        }
    }

    private ApkData a(d dVar) {
        ApkData apkData = new ApkData();
        apkData.apkPackageName = dVar.packageName;
        apkData.apkDeeplinkScheme = dVar.aEt;
        apkData.apkUrl = dVar.downloadUrl;
        apkData.apkStatusCallBack = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.1
            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onJoinDownloadQueue() {
                if (a.this.hlz != null && a.this.hlz.getParent() != null && a.this.mPageContext != null) {
                    a.this.hlz.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download_ready));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadStart(ApkData apkData2) {
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadProgress(long j, long j2) {
                if (a.this.hlz != null && a.this.hlz.getParent() != null) {
                    a.this.hlz.setProgress(j, j2);
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadSucceed(ApkData apkData2) {
                if (a.this.hlz != null && a.this.hlz.getParent() != null && a.this.mPageContext != null) {
                    a.this.hlz.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadFailed(ApkData apkData2, int i, String str) {
                if (a.this.hlz != null && a.this.hlz.getParent() != null && a.this.mPageContext != null) {
                    a.this.hlz.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, a.this.aGh.des));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkStartInstall(ApkData apkData2) {
            }
        };
        return apkData;
    }

    private void E(final x xVar) {
        if (this.hly == null) {
            this.hly = new PendantChildView(this.mPageContext.getPageActivity()) { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.2
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
                    if (this.btq == PendantParentView.Model.VERTICAL) {
                        return 91;
                    }
                    if (this.btq == PendantParentView.Model.VERTICAL_PK) {
                        return 99;
                    }
                    return 104;
                }
            };
            this.hly.setBackgroundColor(0);
            this.hly.setId(a.f.ala_pendant_app_promotion);
        }
        if (this.hlx != null && this.hlx.indexOfChild(this.hly) < 0) {
            this.hlx.a(this.hly, new LinearLayout.LayoutParams(-2, -2));
        }
        if (this.hlz == null) {
            this.hlz = new AlaAppPromotionView(this.mPageContext.getPageActivity());
            this.hlz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.G(xVar);
                    a.this.bYV();
                }
            });
        }
        if (this.hly.indexOfChild(this.hlz) < 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            this.hly.addView(this.hlz, layoutParams);
        }
        this.hly.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYV() {
        ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hlA);
        if (apkStatus == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), this.hlA);
        } else if (apkStatus == ApkStatus.DOWNLOADED) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.hlA, false);
        } else {
            a(this.hlA);
        }
    }

    private void a(ApkData apkData) {
        if (apkData != null) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.hlA, true);
        }
    }

    private void bYW() {
        ApkManager.getInstance().addFileDownloadCallback(this.hlA, this.mPageContext.getPageActivity());
    }

    @Override // com.baidu.live.c.a
    public void xk() {
        ApkManager.getInstance().removeFileDownloadCallback(this.hlA);
        resetView();
    }

    @Override // com.baidu.live.c.a
    public void onStart() {
        bYU();
    }

    @Override // com.baidu.live.c.a
    public void onDestroy() {
        resetView();
    }

    private boolean bYX() {
        if (Build.VERSION.SDK_INT >= 24) {
            return (TextUtils.isEmpty(TbConfig.FILE_PROVIDER_AUTHORITIES) || TextUtils.isEmpty(TbConfig.FILE_OUTPUT_FILE_ROOT_PATH)) ? false : true;
        }
        return true;
    }

    private void F(x xVar) {
        String str;
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hlA) == ApkStatus.READY) {
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
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hlA) == ApkStatus.READY) {
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
