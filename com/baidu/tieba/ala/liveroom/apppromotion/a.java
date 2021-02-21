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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.c.a {
    private d aID;
    private PendantParentView hpZ;
    private PendantChildView hqa;
    private AlaAppPromotionView hqb;
    private ApkData hqc;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.c.a
    public void b(ViewGroup viewGroup, ab abVar) {
        resetView();
        if (abVar == null || abVar.aID == null) {
            this.aID = null;
            this.hqb = null;
            return;
        }
        this.aID = abVar.aID;
        if (viewGroup instanceof PendantParentView) {
            this.hpZ = (PendantParentView) viewGroup;
        }
        D(abVar);
    }

    private void D(ab abVar) {
        if (this.aID.Bi() && caa()) {
            this.hqc = a(this.aID);
            E(abVar);
            bZX();
            F(abVar);
        }
    }

    private void bZX() {
        String string;
        if (this.hqb != null) {
            if (!TextUtils.isEmpty(this.aID.icon) || !TextUtils.isEmpty(this.aID.des)) {
                this.hqb.setImage(this.aID.icon);
                ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hqc);
                if (apkStatus == ApkStatus.READY) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_open, this.aID.des);
                } else if (apkStatus == ApkStatus.DOWNLOADED) {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded);
                } else {
                    string = this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, this.aID.des);
                    if (ApkManager.getInstance().isDownloading(this.hqc)) {
                        bZZ();
                    }
                }
                this.hqb.setStatus(string);
            }
        }
    }

    private void resetView() {
        if (this.hqb != null && (this.hqb.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hqb.getParent()).removeView(this.hqb);
        }
        if (this.hqa != null && (this.hqa.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hqa.getParent()).removeView(this.hqa);
        }
    }

    @Override // com.baidu.live.c.a
    public void setCanVisible(boolean z) {
        if (this.hqb != null) {
            if (z) {
                this.hqb.setVisibility(0);
            } else {
                this.hqb.setVisibility(4);
            }
        }
    }

    private ApkData a(d dVar) {
        ApkData apkData = new ApkData();
        apkData.apkPackageName = dVar.packageName;
        apkData.apkDeeplinkScheme = dVar.aGg;
        apkData.apkUrl = dVar.downloadUrl;
        apkData.apkStatusCallBack = new ApkStatusCallback() { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.1
            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onJoinDownloadQueue() {
                if (a.this.hqb != null && a.this.hqb.getParent() != null && a.this.mPageContext != null) {
                    a.this.hqb.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download_ready));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadStart(ApkData apkData2) {
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadProgress(long j, long j2) {
                if (a.this.hqb != null && a.this.hqb.getParent() != null) {
                    a.this.hqb.setProgress(j, j2);
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadSucceed(ApkData apkData2) {
                if (a.this.hqb != null && a.this.hqb.getParent() != null && a.this.mPageContext != null) {
                    a.this.hqb.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_downloaded));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkDownloadFailed(ApkData apkData2, int i, String str) {
                if (a.this.hqb != null && a.this.hqb.getParent() != null && a.this.mPageContext != null) {
                    a.this.hqb.setStatus(a.this.mPageContext.getResources().getString(a.h.ala_app_promotion_download, a.this.aID.des));
                }
            }

            @Override // com.baidu.live.tbadk.apk.ApkStatusCallback
            public void onApkStartInstall(ApkData apkData2) {
            }
        };
        return apkData;
    }

    private void E(final ab abVar) {
        if (this.hqa == null) {
            this.hqa = new PendantChildView(this.mPageContext.getPageActivity()) { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.2
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
                    if (this.bwT == PendantParentView.Model.VERTICAL) {
                        return 91;
                    }
                    if (this.bwT == PendantParentView.Model.VERTICAL_PK) {
                        return 99;
                    }
                    return 104;
                }
            };
            this.hqa.setBackgroundColor(0);
            this.hqa.setId(a.f.ala_pendant_app_promotion);
        }
        if (this.hpZ != null && this.hpZ.indexOfChild(this.hqa) < 0) {
            this.hpZ.a(this.hqa, new LinearLayout.LayoutParams(-2, -2));
        }
        if (this.hqb == null) {
            this.hqb = new AlaAppPromotionView(this.mPageContext.getPageActivity());
            this.hqb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.apppromotion.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.G(abVar);
                    a.this.bZY();
                }
            });
        }
        if (this.hqa.indexOfChild(this.hqb) < 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            this.hqa.addView(this.hqb, layoutParams);
        }
        this.hqa.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZY() {
        ApkStatus apkStatus = ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hqc);
        if (apkStatus == ApkStatus.READY) {
            ApkManager.getInstance().launchApkByDeeplink(this.mPageContext.getPageActivity(), this.hqc);
        } else if (apkStatus == ApkStatus.DOWNLOADED) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.hqc, false);
        } else {
            a(this.hqc);
        }
    }

    private void a(ApkData apkData) {
        if (apkData != null) {
            ApkManager.getInstance().startDownloadAndLaunchApk(this.mPageContext.getPageActivity(), this.hqc, true);
        }
    }

    private void bZZ() {
        ApkManager.getInstance().addFileDownloadCallback(this.hqc, this.mPageContext.getPageActivity());
    }

    @Override // com.baidu.live.c.a
    public void xh() {
        ApkManager.getInstance().removeFileDownloadCallback(this.hqc);
        resetView();
    }

    @Override // com.baidu.live.c.a
    public void onStart() {
        bZX();
    }

    @Override // com.baidu.live.c.a
    public void onDestroy() {
        resetView();
    }

    private boolean caa() {
        if (Build.VERSION.SDK_INT >= 24) {
            return (TextUtils.isEmpty(TbConfig.FILE_PROVIDER_AUTHORITIES) || TextUtils.isEmpty(TbConfig.FILE_OUTPUT_FILE_ROOT_PATH)) ? false : true;
        }
        return true;
    }

    private void F(ab abVar) {
        String str;
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hqc) == ApkStatus.READY) {
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
        if (ApkManager.getInstance().getApkStatus(this.mPageContext.getPageActivity(), this.hqc) == ApkStatus.READY) {
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
