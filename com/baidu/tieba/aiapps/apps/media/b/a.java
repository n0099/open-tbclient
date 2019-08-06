package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aBc;
    public boolean aBl;
    public String aDi;
    public boolean aDj;
    public boolean dfk;
    public boolean dfl;
    public int dfm;
    public int dfn;
    public String dfo;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.dfk = false;
        this.dfl = false;
        this.dfm = 1;
        this.dfn = 3;
        this.dfo = "vertical";
        this.aDi = "contain";
        this.aBl = false;
        this.aDj = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBc) && this.dfm <= this.dfn;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.aBc + "', mSlaveId='" + this.aDU + "', mMuted=" + this.dfk + ", mBackgroundMuted=" + this.dfl + ", mMinCacheS=" + this.dfm + ", mMaxCacheS=" + this.dfn + ", mOrientation='" + this.dfo + "', mObjectFit='" + this.aDi + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.aBl + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aGg();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) aVar);
        aVar2.aBc = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString("src", aVar.mSrc);
        aVar2.aBl = jSONObject.optBoolean("autoplay", aVar.aBl);
        aVar2.dfk = jSONObject.optBoolean("muted", aVar.dfk);
        aVar2.dfl = jSONObject.optBoolean("backgroundMute", aVar.dfl);
        aVar2.dfo = jSONObject.optString("orientation", aVar.dfo);
        aVar2.aDi = jSONObject.optString("objectFit", aVar.aDi);
        aVar2.dfm = jSONObject.optInt("minCache", aVar.dfm);
        aVar2.dfn = jSONObject.optInt("maxCache", aVar.dfn);
        aVar2.aDj = jSONObject.optBoolean("fullScreen", aVar.aDj);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aGg() {
        return new a();
    }
}
