package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean azC;
    public String azs;
    public boolean cUZ;
    public boolean cVa;
    public int cVb;
    public int cVc;
    public String cVd;
    public String cVe;
    public boolean cVf;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.cUZ = false;
        this.cVa = false;
        this.cVb = 1;
        this.cVc = 3;
        this.cVd = "vertical";
        this.cVe = "contain";
        this.azC = false;
        this.cVf = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.azs) && this.cVb <= this.cVc;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.azs + "', mSlaveId='" + this.aBD + "', mMuted=" + this.cUZ + ", mBackgroundMuted=" + this.cVa + ", mMinCacheS=" + this.cVb + ", mMaxCacheS=" + this.cVc + ", mOrientation='" + this.cVd + "', mObjectFit='" + this.cVe + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.azC + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return azx();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) aVar);
        aVar2.azs = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString("src", aVar.mSrc);
        aVar2.azC = jSONObject.optBoolean("autoplay", aVar.azC);
        aVar2.cUZ = jSONObject.optBoolean("muted", aVar.cUZ);
        aVar2.cVa = jSONObject.optBoolean("backgroundMute", aVar.cVa);
        aVar2.cVd = jSONObject.optString("orientation", aVar.cVd);
        aVar2.cVe = jSONObject.optString("objectFit", aVar.cVe);
        aVar2.cVb = jSONObject.optInt("minCache", aVar.cVb);
        aVar2.cVc = jSONObject.optInt("maxCache", aVar.cVc);
        aVar2.cVf = jSONObject.optBoolean("fullScreen", aVar.cVf);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a azx() {
        return new a();
    }
}
