package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends com.baidu.swan.apps.media.c.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bwp;
    public String mSrc;
    public boolean dZP = false;
    public boolean dZQ = false;
    public int dZR = 1;
    public int dZS = 3;
    public String dZT = VerticalTranslateLayout.VERTICAL;
    public String bAd = "contain";
    public boolean bwx = false;
    public boolean bAe = false;
    public int mDirection = 0;

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bwp) && this.dZR <= this.dZS;
    }

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b
    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.bwp + "', mSlaveId='" + this.bdW + "', mMuted=" + this.dZP + ", mBackgroundMuted=" + this.dZQ + ", mMinCacheS=" + this.dZR + ", mMaxCacheS=" + this.dZS + ", mOrientation='" + this.dZT + "', mObjectFit='" + this.bAd + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.bwx + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aXE();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) aVar);
        aVar2.bwp = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mSrc);
        aVar2.bwx = jSONObject.optBoolean("autoplay", aVar.bwx);
        aVar2.dZP = jSONObject.optBoolean("muted", aVar.dZP);
        aVar2.dZQ = jSONObject.optBoolean("backgroundMute", aVar.dZQ);
        aVar2.dZT = jSONObject.optString("orientation", aVar.dZT);
        aVar2.bAd = jSONObject.optString("objectFit", aVar.bAd);
        aVar2.dZR = jSONObject.optInt("minCache", aVar.dZR);
        aVar2.dZS = jSONObject.optInt("maxCache", aVar.dZS);
        aVar2.bAe = jSONObject.optBoolean("fullScreen", aVar.bAe);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aXE() {
        return new a();
    }
}
