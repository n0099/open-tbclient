package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean aAD;
    public String aAu;
    public String aCA;
    public boolean aCB;
    public boolean ddA;
    public boolean ddB;
    public int ddC;
    public int ddD;
    public String ddE;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.ddA = false;
        this.ddB = false;
        this.ddC = 1;
        this.ddD = 3;
        this.ddE = "vertical";
        this.aCA = "contain";
        this.aAD = false;
        this.aCB = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aAu) && this.ddC <= this.ddD;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.aAu + "', mSlaveId='" + this.aDm + "', mMuted=" + this.ddA + ", mBackgroundMuted=" + this.ddB + ", mMinCacheS=" + this.ddC + ", mMaxCacheS=" + this.ddD + ", mOrientation='" + this.ddE + "', mObjectFit='" + this.aCA + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.aAD + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aEJ();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) aVar);
        aVar2.aAu = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString("src", aVar.mSrc);
        aVar2.aAD = jSONObject.optBoolean("autoplay", aVar.aAD);
        aVar2.ddA = jSONObject.optBoolean("muted", aVar.ddA);
        aVar2.ddB = jSONObject.optBoolean("backgroundMute", aVar.ddB);
        aVar2.ddE = jSONObject.optString("orientation", aVar.ddE);
        aVar2.aCA = jSONObject.optString("objectFit", aVar.aCA);
        aVar2.ddC = jSONObject.optInt("minCache", aVar.ddC);
        aVar2.ddD = jSONObject.optInt("maxCache", aVar.ddD);
        aVar2.aCB = jSONObject.optBoolean("fullScreen", aVar.aCB);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aEJ() {
        return new a();
    }
}
