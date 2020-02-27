package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class a extends com.baidu.swan.apps.media.c.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAy;
    public String mSrc;
    public boolean edS = false;
    public boolean edT = false;
    public int edU = 1;
    public int edV = 3;
    public String edW = VerticalTranslateLayout.VERTICAL;
    public String bEj = "contain";
    public boolean bAG = false;
    public boolean bEk = false;
    public int mDirection = 0;

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAy) && this.edU <= this.edV;
    }

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b
    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.bAy + "', mSlaveId='" + this.bil + "', mMuted=" + this.edS + ", mBackgroundMuted=" + this.edT + ", mMinCacheS=" + this.edU + ", mMaxCacheS=" + this.edV + ", mOrientation='" + this.edW + "', mObjectFit='" + this.bEj + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.bAG + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aZT();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) aVar);
        aVar2.bAy = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mSrc);
        aVar2.bAG = jSONObject.optBoolean("autoplay", aVar.bAG);
        aVar2.edS = jSONObject.optBoolean("muted", aVar.edS);
        aVar2.edT = jSONObject.optBoolean("backgroundMute", aVar.edT);
        aVar2.edW = jSONObject.optString("orientation", aVar.edW);
        aVar2.bEj = jSONObject.optString("objectFit", aVar.bEj);
        aVar2.edU = jSONObject.optInt("minCache", aVar.edU);
        aVar2.edV = jSONObject.optInt("maxCache", aVar.edV);
        aVar2.bEk = jSONObject.optBoolean("fullScreen", aVar.bEk);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aZT() {
        return new a();
    }
}
