package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class a extends com.baidu.swan.apps.media.c.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAL;
    public String mSrc;
    public boolean eew = false;
    public boolean eex = false;
    public int eey = 1;
    public int eez = 3;
    public String eeA = VerticalTranslateLayout.VERTICAL;
    public String bEw = "contain";
    public boolean bAT = false;
    public boolean bEx = false;
    public int mDirection = 0;

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAL) && this.eey <= this.eez;
    }

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b
    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.bAL + "', mSlaveId='" + this.biB + "', mMuted=" + this.eew + ", mBackgroundMuted=" + this.eex + ", mMinCacheS=" + this.eey + ", mMaxCacheS=" + this.eez + ", mOrientation='" + this.eeA + "', mObjectFit='" + this.bEw + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.bAT + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return baa();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) aVar);
        aVar2.bAL = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mSrc);
        aVar2.bAT = jSONObject.optBoolean("autoplay", aVar.bAT);
        aVar2.eew = jSONObject.optBoolean("muted", aVar.eew);
        aVar2.eex = jSONObject.optBoolean("backgroundMute", aVar.eex);
        aVar2.eeA = jSONObject.optString("orientation", aVar.eeA);
        aVar2.bEw = jSONObject.optString("objectFit", aVar.bEw);
        aVar2.eey = jSONObject.optInt("minCache", aVar.eey);
        aVar2.eez = jSONObject.optInt("maxCache", aVar.eez);
        aVar2.bEx = jSONObject.optBoolean("fullScreen", aVar.bEx);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a baa() {
        return new a();
    }
}
