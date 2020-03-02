package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class a extends com.baidu.swan.apps.media.c.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAz;
    public String mSrc;
    public boolean edT = false;
    public boolean edU = false;
    public int edV = 1;
    public int edW = 3;
    public String edX = VerticalTranslateLayout.VERTICAL;
    public String bEk = "contain";
    public boolean bAH = false;
    public boolean bEl = false;
    public int mDirection = 0;

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAz) && this.edV <= this.edW;
    }

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b
    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.bAz + "', mSlaveId='" + this.bim + "', mMuted=" + this.edT + ", mBackgroundMuted=" + this.edU + ", mMinCacheS=" + this.edV + ", mMaxCacheS=" + this.edW + ", mOrientation='" + this.edX + "', mObjectFit='" + this.bEk + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.bAH + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aZV();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) aVar);
        aVar2.bAz = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mSrc);
        aVar2.bAH = jSONObject.optBoolean("autoplay", aVar.bAH);
        aVar2.edT = jSONObject.optBoolean("muted", aVar.edT);
        aVar2.edU = jSONObject.optBoolean("backgroundMute", aVar.edU);
        aVar2.edX = jSONObject.optString("orientation", aVar.edX);
        aVar2.bEk = jSONObject.optString("objectFit", aVar.bEk);
        aVar2.edV = jSONObject.optInt("minCache", aVar.edV);
        aVar2.edW = jSONObject.optInt("maxCache", aVar.edW);
        aVar2.bEl = jSONObject.optBoolean("fullScreen", aVar.bEl);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aZV() {
        return new a();
    }
}
