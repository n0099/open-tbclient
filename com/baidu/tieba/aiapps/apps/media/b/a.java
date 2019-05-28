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
    public boolean ddB;
    public boolean ddC;
    public int ddD;
    public int ddE;
    public String ddF;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.ddB = false;
        this.ddC = false;
        this.ddD = 1;
        this.ddE = 3;
        this.ddF = "vertical";
        this.aCA = "contain";
        this.aAD = false;
        this.aCB = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aAu) && this.ddD <= this.ddE;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.aAu + "', mSlaveId='" + this.aDm + "', mMuted=" + this.ddB + ", mBackgroundMuted=" + this.ddC + ", mMinCacheS=" + this.ddD + ", mMaxCacheS=" + this.ddE + ", mOrientation='" + this.ddF + "', mObjectFit='" + this.aCA + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.aAD + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aEM();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) aVar);
        aVar2.aAu = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString("src", aVar.mSrc);
        aVar2.aAD = jSONObject.optBoolean("autoplay", aVar.aAD);
        aVar2.ddB = jSONObject.optBoolean("muted", aVar.ddB);
        aVar2.ddC = jSONObject.optBoolean("backgroundMute", aVar.ddC);
        aVar2.ddF = jSONObject.optString("orientation", aVar.ddF);
        aVar2.aCA = jSONObject.optString("objectFit", aVar.aCA);
        aVar2.ddD = jSONObject.optInt("minCache", aVar.ddD);
        aVar2.ddE = jSONObject.optInt("maxCache", aVar.ddE);
        aVar2.aCB = jSONObject.optBoolean("fullScreen", aVar.aCB);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aEM() {
        return new a();
    }
}
