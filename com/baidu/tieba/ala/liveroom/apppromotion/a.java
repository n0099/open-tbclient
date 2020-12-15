package com.baidu.tieba.ala.liveroom.apppromotion;

import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.data.d;
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class a implements com.baidu.live.c.a {
    private d aKv;
    private PendantParentView her;
    private PendantChildView hes;
    private AlaAppPromotionView het;
    private ApkData heu;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.c.a
    public void b(ViewGroup viewGroup, w wVar) {
        resetView();
        if (wVar == null || wVar.aKv == null) {
            this.aKv = null;
            this.het = null;
            return;
        }
        this.aKv = wVar.aKv;
        if (viewGroup instanceof PendantParentView) {
            this.her = (PendantParentView) viewGroup;
        }
        D(wVar);
    }

    private void D(w wVar) {
        if (this.aKv.Fe() && cah()) {
            this.heu = a(this.aKv);
            E(wVar);
            cae();
            F(wVar);
        }
    }

    private void cae() {
        String string;
        if (this.het != null) {
            if (!TextUtils.isEmpty(this.aKv.icon) || !TextUtils.isEmpty(this.aKv.des)) {
                this.het.setImage(this.aKv.icon);
                ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.heu);
                if (apkStatus == ApkStatus.READY) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_open, this.aKv.des);
                } else if (apkStatus == ApkStatus.DOWNLOADED) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded);
                } else {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, this.aKv.des);
                    if (ApkManager.getInstance().isDownloading(this.heu)) {
                        cag();
                    }
                }
                this.het.setStatus(string);
            }
        }
    }

    private void resetView() {
        if (this.het != null && (this.het.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.het.getParent()).removeView(this.het);
        }
        if (this.hes != null && (this.hes.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hes.getParent()).removeView(this.hes);
        }
    }

    @Override // com.baidu.live.c.a
    public void setCanVisible(boolean z) {
        if (this.het != null) {
            if (z) {
                this.het.setVisibility(0);
            } else {
                this.het.setVisibility(4);
            }
        }
    }

    private ApkData a(d dVar) {
        ApkData apkData = new ApkData();
        apkData.apkPackageName = dVar.packageName;
        apkData.apkDeeplinkScheme = dVar.aIK;
        apkData.apkUrl = dVar.downloadUrl;
        apkData.apkStatusCallBack = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.1
            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onJoinDownloadQueue() {
                if (a.this.het != null && a.this.het.getParent() != null && a.this.mPageContext != null) {
                    a.this.het.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download_ready));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadStart(ApkData apkData2) {
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadProgress(long j, long j2) {
                if (a.this.het != null && a.this.het.getParent() != null) {
                    a.this.het.setProgress(j, j2);
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadSucceed(ApkData apkData2) {
                if (a.this.het != null && a.this.het.getParent() != null && a.this.mPageContext != null) {
                    a.this.het.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadFailed(ApkData apkData2, int i, String str) {
                if (a.this.het != null && a.this.het.getParent() != null && a.this.mPageContext != null) {
                    a.this.het.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, a.this.aKv.des));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkStartInstall(ApkData apkData2) {
            }
        };
        return apkData;
    }

    private void E(final w wVar) {
        if (this.hes == null) {
            this.hes = new PendantChildView(this.mPageContext.getPageActivity()) { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.2
                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalPkPosition() {
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
                    if (this.btr == PendantParentView.Model.VERTICAL) {
                        return 91;
                    }
                    if (this.btr == PendantParentView.Model.VERTICAL_PK) {
                        return 99;
                    }
                    return 104;
                }
            };
            this.hes.setBackgroundColor(0);
            this.hes.setId(a.f.ala_pendant_app_promotion);
        }
        if (this.her != null && this.her.indexOfChild(this.hes) < 0) {
            this.her.a(this.hes, new LinearLayout.LayoutParams(-2, -2));
        }
        if (this.het == null) {
            this.het = new AlaAppPromotionView(this.mPageContext.getPageActivity());
            this.het.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.G(wVar);
                    a.this.caf();
                }
            });
        }
        if (this.hes.indexOfChild(this.het) < 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            this.hes.addView(this.het, layoutParams);
        }
        this.hes.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caf() {
        ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.heu);
        if (apkStatus == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), this.heu);
        } else if (apkStatus == ApkStatus.DOWNLOADED) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.heu, false);
        } else {
            a(this.heu);
        }
    }

    private void a(ApkData apkData) {
        if (apkData != null) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.heu, true);
        }
    }

    private void cag() {
        ApkManager.getInstance().addFileDownloadCallback(this.heu, this.mPageContext.getPageActivity());
    }

    @Override // com.baidu.live.c.a
    public void Do() {
        ApkManager.getInstance().removeFileDownloadCallback(this.heu);
        resetView();
    }

    @Override // com.baidu.live.c.a
    public void onStart() {
        cae();
    }

    @Override // com.baidu.live.c.a
    public void onDestroy() {
        resetView();
    }

    private boolean cah() {
        if (Build.VERSION.SDK_INT >= 24) {
            return (TextUtils.isEmpty(TbConfig.FILE_PROVIDER_AUTHORITIES) || TextUtils.isEmpty(TbConfig.FILE_OUTPUT_FILE_ROOT_PATH)) ? false : true;
        }
        return true;
    }

    private void F(w wVar) {
        String str;
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.heu) == ApkStatus.READY) {
            str = NotificationCompat.CATEGORY_CALL;
        } else {
            str = "new";
        }
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "guidepop_show");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("live_id", wVar.mLiveInfo.live_id);
            jSONObject.put("vid", wVar.mLiveInfo.feed_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt("", "guidepop", str, jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(w wVar) {
        String str;
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.heu) == ApkStatus.READY) {
            str = NotificationCompat.CATEGORY_CALL;
        } else {
            str = "new";
        }
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "guidepop_clk");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("live_id", wVar.mLiveInfo.live_id);
            jSONObject.put("vid", wVar.mLiveInfo.feed_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt("", "guidepop", str, jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }
}
