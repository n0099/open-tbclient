package com.baidu.tieba.ala.liveroom.apppromotion;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import com.baidu.live.data.ab;
import com.baidu.live.data.d;
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
    private d aKd;
    private PendantParentView hrI;
    private PendantChildView hrJ;
    private AlaAppPromotionView hrK;
    private ApkData hrL;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.c.a
    public void b(ViewGroup viewGroup, ab abVar) {
        resetView();
        if (abVar == null || abVar.aKd == null) {
            this.aKd = null;
            this.hrK = null;
            return;
        }
        this.aKd = abVar.aKd;
        if (viewGroup instanceof PendantParentView) {
            this.hrI = (PendantParentView) viewGroup;
        }
        D(abVar);
    }

    private void D(ab abVar) {
        if (this.aKd.Bl() && cag()) {
            this.hrL = a(this.aKd);
            E(abVar);
            cad();
            F(abVar);
        }
    }

    private void cad() {
        String string;
        if (this.hrK != null) {
            if (!TextUtils.isEmpty(this.aKd.icon) || !TextUtils.isEmpty(this.aKd.des)) {
                this.hrK.setImage(this.aKd.icon);
                ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hrL);
                if (apkStatus == ApkStatus.READY) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_open, this.aKd.des);
                } else if (apkStatus == ApkStatus.DOWNLOADED) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded);
                } else {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, this.aKd.des);
                    if (ApkManager.getInstance().isDownloading(this.hrL)) {
                        caf();
                    }
                }
                this.hrK.setStatus(string);
            }
        }
    }

    private void resetView() {
        if (this.hrK != null && (this.hrK.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hrK.getParent()).removeView(this.hrK);
        }
        if (this.hrJ != null && (this.hrJ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hrJ.getParent()).removeView(this.hrJ);
        }
    }

    @Override // com.baidu.live.c.a
    public void setCanVisible(boolean z) {
        if (this.hrK != null) {
            if (z) {
                this.hrK.setVisibility(0);
            } else {
                this.hrK.setVisibility(4);
            }
        }
    }

    private ApkData a(d dVar) {
        ApkData apkData = new ApkData();
        apkData.apkPackageName = dVar.packageName;
        apkData.apkDeeplinkScheme = dVar.aHG;
        apkData.apkUrl = dVar.downloadUrl;
        apkData.apkStatusCallBack = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.1
            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onJoinDownloadQueue() {
                if (a.this.hrK != null && a.this.hrK.getParent() != null && a.this.mPageContext != null) {
                    a.this.hrK.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download_ready));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadStart(ApkData apkData2) {
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadProgress(long j, long j2) {
                if (a.this.hrK != null && a.this.hrK.getParent() != null) {
                    a.this.hrK.setProgress(j, j2);
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadSucceed(ApkData apkData2) {
                if (a.this.hrK != null && a.this.hrK.getParent() != null && a.this.mPageContext != null) {
                    a.this.hrK.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadFailed(ApkData apkData2, int i, String str) {
                if (a.this.hrK != null && a.this.hrK.getParent() != null && a.this.mPageContext != null) {
                    a.this.hrK.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, a.this.aKd.des));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkStartInstall(ApkData apkData2) {
            }
        };
        return apkData;
    }

    private void E(final ab abVar) {
        if (this.hrJ == null) {
            this.hrJ = new PendantChildView(this.mPageContext.getPageActivity()) { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.2
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
                    if (this.byt == PendantParentView.Model.VERTICAL) {
                        return 91;
                    }
                    if (this.byt == PendantParentView.Model.VERTICAL_PK) {
                        return 99;
                    }
                    return 104;
                }
            };
            this.hrJ.setBackgroundColor(0);
            this.hrJ.setId(a.f.ala_pendant_app_promotion);
        }
        if (this.hrI != null && this.hrI.indexOfChild(this.hrJ) < 0) {
            this.hrI.a(this.hrJ, new LinearLayout.LayoutParams(-2, -2));
        }
        if (this.hrK == null) {
            this.hrK = new AlaAppPromotionView(this.mPageContext.getPageActivity());
            this.hrK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.G(abVar);
                    a.this.cae();
                }
            });
        }
        if (this.hrJ.indexOfChild(this.hrK) < 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            this.hrJ.addView(this.hrK, layoutParams);
        }
        this.hrJ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cae() {
        ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hrL);
        if (apkStatus == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), this.hrL);
        } else if (apkStatus == ApkStatus.DOWNLOADED) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.hrL, false);
        } else {
            a(this.hrL);
        }
    }

    private void a(ApkData apkData) {
        if (apkData != null) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.hrL, true);
        }
    }

    private void caf() {
        ApkManager.getInstance().addFileDownloadCallback(this.hrL, this.mPageContext.getPageActivity());
    }

    @Override // com.baidu.live.c.a
    public void xk() {
        ApkManager.getInstance().removeFileDownloadCallback(this.hrL);
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

    private void F(ab abVar) {
        String str;
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hrL) == ApkStatus.READY) {
            str = NotificationCompat.CATEGORY_CALL;
        } else {
            str = "new";
        }
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "guidepop_show");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("live_id", abVar.mLiveInfo.live_id);
            jSONObject.put("vid", abVar.mLiveInfo.feed_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt("", "guidepop", str, jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(ab abVar) {
        String str;
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hrL) == ApkStatus.READY) {
            str = NotificationCompat.CATEGORY_CALL;
        } else {
            str = "new";
        }
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "guidepop_clk");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("live_id", abVar.mLiveInfo.live_id);
            jSONObject.put("vid", abVar.mLiveInfo.feed_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcStatisticItem.setContentExt("", "guidepop", str, jSONObject);
        UbcStatisticManager.getInstance().logEvent(ubcStatisticItem);
    }
}
