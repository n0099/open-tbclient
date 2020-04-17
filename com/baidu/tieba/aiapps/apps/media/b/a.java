package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class a extends com.baidu.swan.apps.media.c.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bYS;
    public String mSrc;
    public boolean eEn = false;
    public boolean eEo = false;
    public int eEp = 1;
    public int eEq = 3;
    public String eEr = VerticalTranslateLayout.VERTICAL;
    public String cdf = "contain";
    public boolean bZa = false;
    public boolean bsM = false;
    public int mDirection = 0;

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bYS) && this.eEp <= this.eEq;
    }

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b
    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.bYS + "', mSlaveId='" + this.bGJ + "', mMuted=" + this.eEn + ", mBackgroundMuted=" + this.eEo + ", mMinCacheS=" + this.eEp + ", mMaxCacheS=" + this.eEq + ", mOrientation='" + this.eEr + "', mObjectFit='" + this.cdf + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.bZa + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return bie();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) aVar);
        aVar2.bYS = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mSrc);
        aVar2.bZa = jSONObject.optBoolean("autoplay", aVar.bZa);
        aVar2.eEn = jSONObject.optBoolean("muted", aVar.eEn);
        aVar2.eEo = jSONObject.optBoolean("backgroundMute", aVar.eEo);
        aVar2.eEr = jSONObject.optString("orientation", aVar.eEr);
        aVar2.cdf = jSONObject.optString("objectFit", aVar.cdf);
        aVar2.eEp = jSONObject.optInt("minCache", aVar.eEp);
        aVar2.eEq = jSONObject.optInt("maxCache", aVar.eEq);
        aVar2.bsM = jSONObject.optBoolean("fullScreen", aVar.bsM);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a bie() {
        return new a();
    }
}
