package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aBA;
    public boolean aBJ;
    public String aDG;
    public boolean aDH;
    public boolean dgV;
    public boolean dgW;
    public int dgX;
    public int dgY;
    public String dgZ;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.dgV = false;
        this.dgW = false;
        this.dgX = 1;
        this.dgY = 3;
        this.dgZ = "vertical";
        this.aDG = "contain";
        this.aBJ = false;
        this.aDH = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBA) && this.dgX <= this.dgY;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.aBA + "', mSlaveId='" + this.aEs + "', mMuted=" + this.dgV + ", mBackgroundMuted=" + this.dgW + ", mMinCacheS=" + this.dgX + ", mMaxCacheS=" + this.dgY + ", mOrientation='" + this.dgZ + "', mObjectFit='" + this.aDG + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.aBJ + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aGK();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) aVar);
        aVar2.aBA = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString("src", aVar.mSrc);
        aVar2.aBJ = jSONObject.optBoolean("autoplay", aVar.aBJ);
        aVar2.dgV = jSONObject.optBoolean("muted", aVar.dgV);
        aVar2.dgW = jSONObject.optBoolean("backgroundMute", aVar.dgW);
        aVar2.dgZ = jSONObject.optString("orientation", aVar.dgZ);
        aVar2.aDG = jSONObject.optString("objectFit", aVar.aDG);
        aVar2.dgX = jSONObject.optInt("minCache", aVar.dgX);
        aVar2.dgY = jSONObject.optInt("maxCache", aVar.dgY);
        aVar2.aDH = jSONObject.optBoolean("fullScreen", aVar.aDH);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aGK() {
        return new a();
    }
}
