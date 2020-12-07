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
    private PendantParentView hep;
    private PendantChildView heq;
    private AlaAppPromotionView her;
    private ApkData hes;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.c.a
    public void b(ViewGroup viewGroup, w wVar) {
        resetView();
        if (wVar == null || wVar.aKv == null) {
            this.aKv = null;
            this.her = null;
            return;
        }
        this.aKv = wVar.aKv;
        if (viewGroup instanceof PendantParentView) {
            this.hep = (PendantParentView) viewGroup;
        }
        D(wVar);
    }

    private void D(w wVar) {
        if (this.aKv.Fe() && cag()) {
            this.hes = a(this.aKv);
            E(wVar);
            cad();
            F(wVar);
        }
    }

    private void cad() {
        String string;
        if (this.her != null) {
            if (!TextUtils.isEmpty(this.aKv.icon) || !TextUtils.isEmpty(this.aKv.des)) {
                this.her.setImage(this.aKv.icon);
                ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hes);
                if (apkStatus == ApkStatus.READY) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_open, this.aKv.des);
                } else if (apkStatus == ApkStatus.DOWNLOADED) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded);
                } else {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, this.aKv.des);
                    if (ApkManager.getInstance().isDownloading(this.hes)) {
                        caf();
                    }
                }
                this.her.setStatus(string);
            }
        }
    }

    private void resetView() {
        if (this.her != null && (this.her.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.her.getParent()).removeView(this.her);
        }
        if (this.heq != null && (this.heq.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.heq.getParent()).removeView(this.heq);
        }
    }

    @Override // com.baidu.live.c.a
    public void setCanVisible(boolean z) {
        if (this.her != null) {
            if (z) {
                this.her.setVisibility(0);
            } else {
                this.her.setVisibility(4);
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
                if (a.this.her != null && a.this.her.getParent() != null && a.this.mPageContext != null) {
                    a.this.her.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download_ready));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadStart(ApkData apkData2) {
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadProgress(long j, long j2) {
                if (a.this.her != null && a.this.her.getParent() != null) {
                    a.this.her.setProgress(j, j2);
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadSucceed(ApkData apkData2) {
                if (a.this.her != null && a.this.her.getParent() != null && a.this.mPageContext != null) {
                    a.this.her.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadFailed(ApkData apkData2, int i, String str) {
                if (a.this.her != null && a.this.her.getParent() != null && a.this.mPageContext != null) {
                    a.this.her.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, a.this.aKv.des));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkStartInstall(ApkData apkData2) {
            }
        };
        return apkData;
    }

    private void E(final w wVar) {
        if (this.heq == null) {
            this.heq = new PendantChildView(this.mPageContext.getPageActivity()) { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.2
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
            this.heq.setBackgroundColor(0);
            this.heq.setId(a.f.ala_pendant_app_promotion);
        }
        if (this.hep != null && this.hep.indexOfChild(this.heq) < 0) {
            this.hep.a(this.heq, new LinearLayout.LayoutParams(-2, -2));
        }
        if (this.her == null) {
            this.her = new AlaAppPromotionView(this.mPageContext.getPageActivity());
            this.her.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.G(wVar);
                    a.this.cae();
                }
            });
        }
        if (this.heq.indexOfChild(this.her) < 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            this.heq.addView(this.her, layoutParams);
        }
        this.heq.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cae() {
        ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hes);
        if (apkStatus == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), this.hes);
        } else if (apkStatus == ApkStatus.DOWNLOADED) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.hes, false);
        } else {
            a(this.hes);
        }
    }

    private void a(ApkData apkData) {
        if (apkData != null) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.hes, true);
        }
    }

    private void caf() {
        ApkManager.getInstance().addFileDownloadCallback(this.hes, this.mPageContext.getPageActivity());
    }

    @Override // com.baidu.live.c.a
    public void Do() {
        ApkManager.getInstance().removeFileDownloadCallback(this.hes);
        resetView();
    }

    @Override // com.baidu.live.c.a
    public void onStart() {
        cad();
    }

    @Override // com.baidu.live.c.a
    public void onDestroy() {
        resetView();
    }

    private boolean cag() {
        if (Build.VERSION.SDK_INT >= 24) {
            return (TextUtils.isEmpty(TbConfig.FILE_PROVIDER_AUTHORITIES) || TextUtils.isEmpty(TbConfig.FILE_OUTPUT_FILE_ROOT_PATH)) ? false : true;
        }
        return true;
    }

    private void F(w wVar) {
        String str;
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hes) == ApkStatus.READY) {
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
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hes) == ApkStatus.READY) {
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
