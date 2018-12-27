package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b extends AiAppsNaViewModel {
    public boolean bIN;
    public boolean bIO;
    public int bIP;
    public int bIQ;
    public String bIR;
    public String bIS;
    public boolean bIT;
    public boolean mAutoPlay;
    public int mDirection;
    public String mPlayerId;
    public String mSrc;

    public b() {
        super("liveId", AiAppsNAViewType.LIVEPLAYER);
        this.bIN = false;
        this.bIO = false;
        this.bIP = 1;
        this.bIQ = 3;
        this.bIR = "vertical";
        this.bIS = "contain";
        this.mAutoPlay = false;
        this.bIT = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return !TextUtils.isEmpty(this.mPlayerId) && this.bIP <= this.bIQ;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bIN + ", mBackgroundMuted=" + this.bIO + ", mMinCacheS=" + this.bIP + ", mMaxCacheS=" + this.bIQ + ", mOrientation='" + this.bIR + "', mObjectFit='" + this.bIS + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.mAutoPlay + '}';
    }

    public static b a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject == null) {
            return YM();
        }
        b bVar2 = new b();
        bVar2.updateFromJson(jSONObject, bVar);
        bVar2.mPlayerId = jSONObject.optString("liveId");
        bVar2.mSrc = jSONObject.optString(ImageCoverViewModel.KEY_SRC, bVar.mSrc);
        bVar2.mAutoPlay = jSONObject.optBoolean("autoplay", bVar.mAutoPlay);
        bVar2.bIN = jSONObject.optBoolean("muted", bVar.bIN);
        bVar2.bIO = jSONObject.optBoolean("backgroundMute", bVar.bIO);
        bVar2.bIR = jSONObject.optString("orientation", bVar.bIR);
        bVar2.bIS = jSONObject.optString("objectFit", bVar.bIS);
        bVar2.bIP = jSONObject.optInt("minCache", bVar.bIP);
        bVar2.bIQ = jSONObject.optInt("maxCache", bVar.bIQ);
        bVar2.bIT = jSONObject.optBoolean("fullScreen", bVar.bIT);
        bVar2.mDirection = jSONObject.optInt("direction", bVar.mDirection);
        return bVar2;
    }

    public static b YM() {
        return new b();
    }
}
