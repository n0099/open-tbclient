package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class a extends com.baidu.swan.apps.media.c.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bYY;
    public String mSrc;
    public boolean eEs = false;
    public boolean eEt = false;
    public int eEu = 1;
    public int eEv = 3;
    public String eEw = VerticalTranslateLayout.VERTICAL;
    public String cdm = "contain";
    public boolean bZg = false;
    public boolean bsQ = false;
    public int mDirection = 0;

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bYY) && this.eEu <= this.eEv;
    }

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b
    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.bYY + "', mSlaveId='" + this.bGO + "', mMuted=" + this.eEs + ", mBackgroundMuted=" + this.eEt + ", mMinCacheS=" + this.eEu + ", mMaxCacheS=" + this.eEv + ", mOrientation='" + this.eEw + "', mObjectFit='" + this.cdm + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.bZg + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return bic();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) aVar);
        aVar2.bYY = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mSrc);
        aVar2.bZg = jSONObject.optBoolean("autoplay", aVar.bZg);
        aVar2.eEs = jSONObject.optBoolean("muted", aVar.eEs);
        aVar2.eEt = jSONObject.optBoolean("backgroundMute", aVar.eEt);
        aVar2.eEw = jSONObject.optString("orientation", aVar.eEw);
        aVar2.cdm = jSONObject.optString("objectFit", aVar.cdm);
        aVar2.eEu = jSONObject.optInt("minCache", aVar.eEu);
        aVar2.eEv = jSONObject.optInt("maxCache", aVar.eEv);
        aVar2.bsQ = jSONObject.optBoolean("fullScreen", aVar.bsQ);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a bic() {
        return new a();
    }
}
