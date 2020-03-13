package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class a extends com.baidu.swan.apps.media.c.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAA;
    public String mSrc;
    public boolean eeg = false;
    public boolean eeh = false;
    public int eei = 1;
    public int eej = 3;
    public String eek = VerticalTranslateLayout.VERTICAL;
    public String bEl = "contain";
    public boolean bAI = false;
    public boolean bEm = false;
    public int mDirection = 0;

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAA) && this.eei <= this.eej;
    }

    @Override // com.baidu.swan.apps.media.c.c, com.baidu.swan.apps.component.b.b
    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.bAA + "', mSlaveId='" + this.bin + "', mMuted=" + this.eeg + ", mBackgroundMuted=" + this.eeh + ", mMinCacheS=" + this.eei + ", mMaxCacheS=" + this.eej + ", mOrientation='" + this.eek + "', mObjectFit='" + this.bEl + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.bAI + '}';
    }

    public static a a(JSONObject jSONObject, @NonNull a aVar) {
        if (jSONObject == null) {
            return aZW();
        }
        a aVar2 = new a();
        aVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) aVar);
        aVar2.bAA = jSONObject.optString("liveId");
        aVar2.mSrc = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mSrc);
        aVar2.bAI = jSONObject.optBoolean("autoplay", aVar.bAI);
        aVar2.eeg = jSONObject.optBoolean("muted", aVar.eeg);
        aVar2.eeh = jSONObject.optBoolean("backgroundMute", aVar.eeh);
        aVar2.eek = jSONObject.optString("orientation", aVar.eek);
        aVar2.bEl = jSONObject.optString("objectFit", aVar.bEl);
        aVar2.eei = jSONObject.optInt("minCache", aVar.eei);
        aVar2.eej = jSONObject.optInt("maxCache", aVar.eej);
        aVar2.bEm = jSONObject.optBoolean("fullScreen", aVar.bEm);
        aVar2.mDirection = jSONObject.optInt("direction", aVar.mDirection);
        return aVar2;
    }

    public static a aZW() {
        return new a();
    }
}
