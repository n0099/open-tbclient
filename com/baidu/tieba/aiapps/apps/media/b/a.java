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
    public boolean ddC;
    public boolean ddD;
    public int ddE;
    public int ddF;
    public String ddG;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.ddC = false;
        this.ddD = false;
        this.ddE = 1;
        this.ddF = 3;
        this.ddG = "vertical";
        this.aCA = "contain";
        this.aAD = false;
        this.aCB = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aAu) && this.ddE <= this.ddF;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.aAu + "', mSlaveId='" + this.aDm + "', mMuted=" + this.ddC + ", mBackgroundMuted=" + this.ddD + ", mMinCacheS=" + this.ddE + ", mMaxCacheS=" + this.ddF + ", mOrientation='" + this.ddG + "', mObjectFit='" + this.aCA + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.aAD + '}';
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
        aVar2.ddC = jSONObject.optBoolean("muted", aVar.ddC);
        aVar2.ddD = jSONObject.optBoolean("backgroundMute", aVar.ddD);
        aVar2.ddG = jSONObject.optString("orientation", aVar.ddG);
        aVar2.aCA = jSONObject.optString("objectFit", aVar.aCA);
        aVar2.ddE = jSONObject.optInt("minCache", aVar.ddE);
        aVar2.ddF = jSONObject.optInt("maxCache", aVar.ddF);
        aVar2.aCB = jSONObject.optBoolean("fullScreen", aVar.aCB);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aEM() {
        return new a();
    }
}
