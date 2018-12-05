package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b extends AiAppsNaViewModel {
    public boolean bIK;
    public boolean bIL;
    public int bIM;
    public int bIN;
    public String bIO;
    public String bIP;
    public boolean bIQ;
    public boolean mAutoPlay;
    public int mDirection;
    public String mPlayerId;
    public String mSrc;

    public b() {
        super("liveId", AiAppsNAViewType.LIVEPLAYER);
        this.bIK = false;
        this.bIL = false;
        this.bIM = 1;
        this.bIN = 3;
        this.bIO = "vertical";
        this.bIP = "contain";
        this.mAutoPlay = false;
        this.bIQ = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return !TextUtils.isEmpty(this.mPlayerId) && this.bIM <= this.bIN;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bIK + ", mBackgroundMuted=" + this.bIL + ", mMinCacheS=" + this.bIM + ", mMaxCacheS=" + this.bIN + ", mOrientation='" + this.bIO + "', mObjectFit='" + this.bIP + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.mAutoPlay + '}';
    }

    public static b a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject == null) {
            return YK();
        }
        b bVar2 = new b();
        bVar2.updateFromJson(jSONObject, bVar);
        bVar2.mPlayerId = jSONObject.optString("liveId");
        bVar2.mSrc = jSONObject.optString(ImageCoverViewModel.KEY_SRC, bVar.mSrc);
        bVar2.mAutoPlay = jSONObject.optBoolean("autoplay", bVar.mAutoPlay);
        bVar2.bIK = jSONObject.optBoolean("muted", bVar.bIK);
        bVar2.bIL = jSONObject.optBoolean("backgroundMute", bVar.bIL);
        bVar2.bIO = jSONObject.optString("orientation", bVar.bIO);
        bVar2.bIP = jSONObject.optString("objectFit", bVar.bIP);
        bVar2.bIM = jSONObject.optInt("minCache", bVar.bIM);
        bVar2.bIN = jSONObject.optInt("maxCache", bVar.bIN);
        bVar2.bIQ = jSONObject.optBoolean("fullScreen", bVar.bIQ);
        bVar2.mDirection = jSONObject.optInt("direction", bVar.mDirection);
        return bVar2;
    }

    public static b YK() {
        return new b();
    }
}
