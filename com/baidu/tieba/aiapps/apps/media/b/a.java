package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean azG;
    public String azw;
    public boolean cVc;
    public boolean cVd;
    public int cVe;
    public int cVf;
    public String cVg;
    public String cVh;
    public boolean cVi;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.cVc = false;
        this.cVd = false;
        this.cVe = 1;
        this.cVf = 3;
        this.cVg = "vertical";
        this.cVh = "contain";
        this.azG = false;
        this.cVi = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.azw) && this.cVe <= this.cVf;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.azw + "', mSlaveId='" + this.aBH + "', mMuted=" + this.cVc + ", mBackgroundMuted=" + this.cVd + ", mMinCacheS=" + this.cVe + ", mMaxCacheS=" + this.cVf + ", mOrientation='" + this.cVg + "', mObjectFit='" + this.cVh + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.azG + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return azu();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) aVar);
        aVar2.azw = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString("src", aVar.mSrc);
        aVar2.azG = jSONObject.optBoolean("autoplay", aVar.azG);
        aVar2.cVc = jSONObject.optBoolean("muted", aVar.cVc);
        aVar2.cVd = jSONObject.optBoolean("backgroundMute", aVar.cVd);
        aVar2.cVg = jSONObject.optString("orientation", aVar.cVg);
        aVar2.cVh = jSONObject.optString("objectFit", aVar.cVh);
        aVar2.cVe = jSONObject.optInt("minCache", aVar.cVe);
        aVar2.cVf = jSONObject.optInt("maxCache", aVar.cVf);
        aVar2.cVi = jSONObject.optBoolean("fullScreen", aVar.cVi);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a azu() {
        return new a();
    }
}
