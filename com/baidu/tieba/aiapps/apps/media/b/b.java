package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b extends AiAppsNaViewModel {
    public boolean bJB;
    public boolean bJC;
    public int bJD;
    public int bJE;
    public String bJF;
    public String bJG;
    public boolean bJH;
    public boolean mAutoPlay;
    public int mDirection;
    public String mPlayerId;
    public String mSrc;

    public b() {
        super("liveId", AiAppsNAViewType.LIVEPLAYER);
        this.bJB = false;
        this.bJC = false;
        this.bJD = 1;
        this.bJE = 3;
        this.bJF = "vertical";
        this.bJG = "contain";
        this.mAutoPlay = false;
        this.bJH = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return !TextUtils.isEmpty(this.mPlayerId) && this.bJD <= this.bJE;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bJB + ", mBackgroundMuted=" + this.bJC + ", mMinCacheS=" + this.bJD + ", mMaxCacheS=" + this.bJE + ", mOrientation='" + this.bJF + "', mObjectFit='" + this.bJG + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.mAutoPlay + '}';
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
        bVar2.bJB = jSONObject.optBoolean("muted", bVar.bJB);
        bVar2.bJC = jSONObject.optBoolean("backgroundMute", bVar.bJC);
        bVar2.bJF = jSONObject.optString("orientation", bVar.bJF);
        bVar2.bJG = jSONObject.optString("objectFit", bVar.bJG);
        bVar2.bJD = jSONObject.optInt("minCache", bVar.bJD);
        bVar2.bJE = jSONObject.optInt("maxCache", bVar.bJE);
        bVar2.bJH = jSONObject.optBoolean("fullScreen", bVar.bJH);
        bVar2.mDirection = jSONObject.optInt("direction", bVar.mDirection);
        return bVar2;
    }

    public static b Zj() {
        return new b();
    }
}
