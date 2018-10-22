package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b extends AiAppsNaViewModel {
    public String bEA;
    public boolean bEB;
    public boolean bEv;
    public boolean bEw;
    public int bEx;
    public int bEy;
    public String bEz;
    public boolean mAutoPlay;
    public int mDirection;
    public String mPlayerId;
    public String mSrc;

    public b() {
        super("liveId", AiAppsNAViewType.LIVEPLAYER);
        this.bEv = false;
        this.bEw = false;
        this.bEx = 1;
        this.bEy = 3;
        this.bEz = "vertical";
        this.bEA = "contain";
        this.mAutoPlay = false;
        this.bEB = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return !TextUtils.isEmpty(this.mPlayerId) && this.bEx <= this.bEy;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bEv + ", mBackgroundMuted=" + this.bEw + ", mMinCacheS=" + this.bEx + ", mMaxCacheS=" + this.bEy + ", mOrientation='" + this.bEz + "', mObjectFit='" + this.bEA + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.mAutoPlay + '}';
    }

    public static b a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject == null) {
            return Xx();
        }
        b bVar2 = new b();
        bVar2.updateFromJson(jSONObject, bVar);
        bVar2.mPlayerId = jSONObject.optString("liveId");
        bVar2.mSrc = jSONObject.optString(ImageCoverViewModel.KEY_SRC, bVar.mSrc);
        bVar2.mAutoPlay = jSONObject.optBoolean("autoplay", bVar.mAutoPlay);
        bVar2.bEv = jSONObject.optBoolean("muted", bVar.bEv);
        bVar2.bEw = jSONObject.optBoolean("backgroundMute", bVar.bEw);
        bVar2.bEz = jSONObject.optString("orientation", bVar.bEz);
        bVar2.bEA = jSONObject.optString("objectFit", bVar.bEA);
        bVar2.bEx = jSONObject.optInt("minCache", bVar.bEx);
        bVar2.bEy = jSONObject.optInt("maxCache", bVar.bEy);
        bVar2.bEB = jSONObject.optBoolean("fullScreen", bVar.bEB);
        bVar2.mDirection = jSONObject.optInt("direction", bVar.mDirection);
        return bVar2;
    }

    public static b Xx() {
        return new b();
    }
}
