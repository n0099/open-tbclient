package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aUO;
    public boolean aUX;
    public String aWV;
    public boolean aWW;
    public boolean dqr;
    public boolean dqs;
    public int dqt;
    public int dqu;
    public String dqv;
    public int mDirection;
    public String mSrc;

    public a() {
        super("liveId", "livePlayer");
        this.dqr = false;
        this.dqs = false;
        this.dqt = 1;
        this.dqu = 3;
        this.dqv = VerticalTranslateLayout.VERTICAL;
        this.aWV = "contain";
        this.aUX = false;
        this.aWW = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aUO) && this.dqt <= this.dqu;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.aUO + "', mSlaveId='" + this.aXH + "', mMuted=" + this.dqr + ", mBackgroundMuted=" + this.dqs + ", mMinCacheS=" + this.dqt + ", mMaxCacheS=" + this.dqu + ", mOrientation='" + this.dqv + "', mObjectFit='" + this.aWV + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.aUX + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aGX();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) aVar);
        aVar2.aUO = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString("src", aVar.mSrc);
        aVar2.aUX = jSONObject.optBoolean("autoplay", aVar.aUX);
        aVar2.dqr = jSONObject.optBoolean("muted", aVar.dqr);
        aVar2.dqs = jSONObject.optBoolean("backgroundMute", aVar.dqs);
        aVar2.dqv = jSONObject.optString("orientation", aVar.dqv);
        aVar2.aWV = jSONObject.optString("objectFit", aVar.aWV);
        aVar2.dqt = jSONObject.optInt("minCache", aVar.dqt);
        aVar2.dqu = jSONObject.optInt("maxCache", aVar.dqu);
        aVar2.aWW = jSONObject.optBoolean("fullScreen", aVar.aWW);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aGX() {
        return new a();
    }
}
