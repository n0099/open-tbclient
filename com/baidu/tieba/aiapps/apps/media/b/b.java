package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b extends AiAppsNaViewModel {
    public boolean bJA;
    public boolean bJB;
    public int bJC;
    public int bJD;
    public String bJE;
    public String bJF;
    public boolean bJG;
    public boolean mAutoPlay;
    public int mDirection;
    public String mPlayerId;
    public String mSrc;

    public b() {
        super("liveId", AiAppsNAViewType.LIVEPLAYER);
        this.bJA = false;
        this.bJB = false;
        this.bJC = 1;
        this.bJD = 3;
        this.bJE = "vertical";
        this.bJF = "contain";
        this.mAutoPlay = false;
        this.bJG = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return !TextUtils.isEmpty(this.mPlayerId) && this.bJC <= this.bJD;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bJA + ", mBackgroundMuted=" + this.bJB + ", mMinCacheS=" + this.bJC + ", mMaxCacheS=" + this.bJD + ", mOrientation='" + this.bJE + "', mObjectFit='" + this.bJF + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.mAutoPlay + '}';
    }

    public static b a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject == null) {
            return Zj();
        }
        b bVar2 = new b();
        bVar2.updateFromJson(jSONObject, bVar);
        bVar2.mPlayerId = jSONObject.optString("liveId");
        bVar2.mSrc = jSONObject.optString(ImageCoverViewModel.KEY_SRC, bVar.mSrc);
        bVar2.mAutoPlay = jSONObject.optBoolean("autoplay", bVar.mAutoPlay);
        bVar2.bJA = jSONObject.optBoolean("muted", bVar.bJA);
        bVar2.bJB = jSONObject.optBoolean("backgroundMute", bVar.bJB);
        bVar2.bJE = jSONObject.optString("orientation", bVar.bJE);
        bVar2.bJF = jSONObject.optString("objectFit", bVar.bJF);
        bVar2.bJC = jSONObject.optInt("minCache", bVar.bJC);
        bVar2.bJD = jSONObject.optInt("maxCache", bVar.bJD);
        bVar2.bJG = jSONObject.optBoolean("fullScreen", bVar.bJG);
        bVar2.mDirection = jSONObject.optInt("direction", bVar.mDirection);
        return bVar2;
    }

    public static b Zj() {
        return new b();
    }
}
