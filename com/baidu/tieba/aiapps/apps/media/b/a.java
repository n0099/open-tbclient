package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a extends com.baidu.swan.apps.media.c.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bvC;
    public String mSrc;
    public boolean dZG = false;
    public boolean dZH = false;
    public int dZI = 1;
    public int dZJ = 3;
    public String dZK = VerticalTranslateLayout.VERTICAL;
    public String bzq = "contain";
    public boolean bvK = false;
    public boolean bzr = false;
    public int mDirection = 0;

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bvC) && this.dZI <= this.dZJ;
    }

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b
    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.bvC + "', mSlaveId='" + this.bdi + "', mMuted=" + this.dZG + ", mBackgroundMuted=" + this.dZH + ", mMinCacheS=" + this.dZI + ", mMaxCacheS=" + this.dZJ + ", mOrientation='" + this.dZK + "', mObjectFit='" + this.bzq + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.bvK + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aXk();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) aVar);
        aVar2.bvC = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mSrc);
        aVar2.bvK = jSONObject.optBoolean("autoplay", aVar.bvK);
        aVar2.dZG = jSONObject.optBoolean("muted", aVar.dZG);
        aVar2.dZH = jSONObject.optBoolean("backgroundMute", aVar.dZH);
        aVar2.dZK = jSONObject.optString("orientation", aVar.dZK);
        aVar2.bzq = jSONObject.optString("objectFit", aVar.bzq);
        aVar2.dZI = jSONObject.optInt("minCache", aVar.dZI);
        aVar2.dZJ = jSONObject.optInt("maxCache", aVar.dZJ);
        aVar2.bzr = jSONObject.optBoolean("fullScreen", aVar.bzr);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aXk() {
        return new a();
    }
}
