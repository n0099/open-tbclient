package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public boolean azB;
    public String azr;
    public boolean cVd;
    public boolean cVe;
    public int cVf;
    public int cVg;
    public String cVh;
    public String cVi;
    public boolean cVj;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.cVd = false;
        this.cVe = false;
        this.cVf = 1;
        this.cVg = 3;
        this.cVh = "vertical";
        this.cVi = "contain";
        this.azB = false;
        this.cVj = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.azr) && this.cVf <= this.cVg;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.azr + "', mSlaveId='" + this.aBC + "', mMuted=" + this.cVd + ", mBackgroundMuted=" + this.cVe + ", mMinCacheS=" + this.cVf + ", mMaxCacheS=" + this.cVg + ", mOrientation='" + this.cVh + "', mObjectFit='" + this.cVi + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.azB + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return azy();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) aVar);
        aVar2.azr = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString("src", aVar.mSrc);
        aVar2.azB = jSONObject.optBoolean("autoplay", aVar.azB);
        aVar2.cVd = jSONObject.optBoolean("muted", aVar.cVd);
        aVar2.cVe = jSONObject.optBoolean("backgroundMute", aVar.cVe);
        aVar2.cVh = jSONObject.optString("orientation", aVar.cVh);
        aVar2.cVi = jSONObject.optString("objectFit", aVar.cVi);
        aVar2.cVf = jSONObject.optInt("minCache", aVar.cVf);
        aVar2.cVg = jSONObject.optInt("maxCache", aVar.cVg);
        aVar2.cVj = jSONObject.optBoolean("fullScreen", aVar.cVj);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a azy() {
        return new a();
    }
}
