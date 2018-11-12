package com.baidu.tieba.aiapps.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b extends AiAppsNaViewModel {
    public boolean bFh;
    public boolean bFi;
    public int bFj;
    public int bFk;
    public String bFl;
    public String bFm;
    public boolean bFn;
    public boolean mAutoPlay;
    public int mDirection;
    public String mPlayerId;
    public String mSrc;

    public b() {
        super("liveId", AiAppsNAViewType.LIVEPLAYER);
        this.bFh = false;
        this.bFi = false;
        this.bFj = 1;
        this.bFk = 3;
        this.bFl = "vertical";
        this.bFm = "contain";
        this.mAutoPlay = false;
        this.bFn = false;
        this.mDirection = 0;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return !TextUtils.isEmpty(this.mPlayerId) && this.bFj <= this.bFk;
    }

    public String toString() {
        return "LivePlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bFh + ", mBackgroundMuted=" + this.bFi + ", mMinCacheS=" + this.bFj + ", mMaxCacheS=" + this.bFk + ", mOrientation='" + this.bFl + "', mObjectFit='" + this.bFm + "', mSrc='" + this.mSrc + "', mAutoPlay=" + this.mAutoPlay + '}';
    }

    public static b a(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject == null) {
            return XH();
        }
        b bVar2 = new b();
        bVar2.updateFromJson(jSONObject, bVar);
        bVar2.mPlayerId = jSONObject.optString("liveId");
        bVar2.mSrc = jSONObject.optString(ImageCoverViewModel.KEY_SRC, bVar.mSrc);
        bVar2.mAutoPlay = jSONObject.optBoolean("autoplay", bVar.mAutoPlay);
        bVar2.bFh = jSONObject.optBoolean("muted", bVar.bFh);
        bVar2.bFi = jSONObject.optBoolean("backgroundMute", bVar.bFi);
        bVar2.bFl = jSONObject.optString("orientation", bVar.bFl);
        bVar2.bFm = jSONObject.optString("objectFit", bVar.bFm);
        bVar2.bFj = jSONObject.optInt("minCache", bVar.bFj);
        bVar2.bFk = jSONObject.optInt("maxCache", bVar.bFk);
        bVar2.bFn = jSONObject.optBoolean("fullScreen", bVar.bFn);
        bVar2.mDirection = jSONObject.optInt("direction", bVar.mDirection);
        return bVar2;
    }

    public static b XH() {
        return new b();
    }
}
