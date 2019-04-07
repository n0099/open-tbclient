package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean azF;
    public String azv;
    public boolean cVb;
    public boolean cVc;
    public int cVd;
    public int cVe;
    public String cVf;
    public String cVg;
    public boolean cVh;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.cVb = false;
        this.cVc = false;
        this.cVd = 1;
        this.cVe = 3;
        this.cVf = "vertical";
        this.cVg = "contain";
        this.azF = false;
        this.cVh = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.azv) && this.cVd <= this.cVe;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.azv + "', mSlaveId='" + this.aBG + "', mMuted=" + this.cVb + ", mBackgroundMuted=" + this.cVc + ", mMinCacheS=" + this.cVd + ", mMaxCacheS=" + this.cVe + ", mOrientation='" + this.cVf + "', mObjectFit='" + this.cVg + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.azF + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return azu();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) aVar);
        aVar2.azv = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString("src", aVar.mSrc);
        aVar2.azF = jSONObject.optBoolean("autoplay", aVar.azF);
        aVar2.cVb = jSONObject.optBoolean("muted", aVar.cVb);
        aVar2.cVc = jSONObject.optBoolean("backgroundMute", aVar.cVc);
        aVar2.cVf = jSONObject.optString("orientation", aVar.cVf);
        aVar2.cVg = jSONObject.optString("objectFit", aVar.cVg);
        aVar2.cVd = jSONObject.optInt("minCache", aVar.cVd);
        aVar2.cVe = jSONObject.optInt("maxCache", aVar.cVe);
        aVar2.cVh = jSONObject.optBoolean("fullScreen", aVar.cVh);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a azu() {
        return new a();
    }
}
