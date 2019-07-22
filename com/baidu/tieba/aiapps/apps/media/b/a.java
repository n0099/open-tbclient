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
    public boolean dfd;
    public boolean dfe;
    public int dff;
    public int dfg;
    public String dfh;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.dfd = false;
        this.dfe = false;
        this.dff = 1;
        this.dfg = 3;
        this.dfh = "vertical";
        this.aDi = "contain";
        this.aBl = false;
        this.aDj = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBc) && this.dff <= this.dfg;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.aBc + "', mSlaveId='" + this.aDU + "', mMuted=" + this.dfd + ", mBackgroundMuted=" + this.dfe + ", mMinCacheS=" + this.dff + ", mMaxCacheS=" + this.dfg + ", mOrientation='" + this.dfh + "', mObjectFit='" + this.aDi + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.aBl + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aGe();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) aVar);
        aVar2.aBc = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString("src", aVar.mSrc);
        aVar2.aBl = jSONObject.optBoolean("autoplay", aVar.aBl);
        aVar2.dfd = jSONObject.optBoolean("muted", aVar.dfd);
        aVar2.dfe = jSONObject.optBoolean("backgroundMute", aVar.dfe);
        aVar2.dfh = jSONObject.optString("orientation", aVar.dfh);
        aVar2.aDi = jSONObject.optString("objectFit", aVar.aDi);
        aVar2.dff = jSONObject.optInt("minCache", aVar.dff);
        aVar2.dfg = jSONObject.optInt("maxCache", aVar.dfg);
        aVar2.aDj = jSONObject.optBoolean("fullScreen", aVar.aDj);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aGe() {
        return new a();
    }
}
