package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean aUF;
    public String aUw;
    public String aWD;
    public boolean aWE;
    public boolean dpA;
    public boolean dpB;
    public int dpC;
    public int dpD;
    public String dpE;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.dpA = false;
        this.dpB = false;
        this.dpC = 1;
        this.dpD = 3;
        this.dpE = VerticalTranslateLayout.VERTICAL;
        this.aWD = "contain";
        this.aUF = false;
        this.aWE = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aUw) && this.dpC <= this.dpD;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.aUw + "', mSlaveId='" + this.aXp + "', mMuted=" + this.dpA + ", mBackgroundMuted=" + this.dpB + ", mMinCacheS=" + this.dpC + ", mMaxCacheS=" + this.dpD + ", mOrientation='" + this.dpE + "', mObjectFit='" + this.aWD + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.aUF + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aGV();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) aVar);
        aVar2.aUw = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString("src", aVar.mSrc);
        aVar2.aUF = jSONObject.optBoolean("autoplay", aVar.aUF);
        aVar2.dpA = jSONObject.optBoolean("muted", aVar.dpA);
        aVar2.dpB = jSONObject.optBoolean("backgroundMute", aVar.dpB);
        aVar2.dpE = jSONObject.optString("orientation", aVar.dpE);
        aVar2.aWD = jSONObject.optString("objectFit", aVar.aWD);
        aVar2.dpC = jSONObject.optInt("minCache", aVar.dpC);
        aVar2.dpD = jSONObject.optInt("maxCache", aVar.dpD);
        aVar2.aWE = jSONObject.optBoolean("fullScreen", aVar.aWE);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aGV() {
        return new a();
    }
}
