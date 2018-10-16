package com.baidu.tieba.aiapps.apps.media.video;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends AiAppsNaViewModel {
    public String bEA;
    public boolean bEB;
    public boolean bES;
    public String bET;
    public int bEU;
    public String bEV;
    public String bEW;
    public boolean bEX;
    public boolean bEY;
    public boolean bEZ;
    private boolean bFa;
    private boolean bFb;
    private boolean bFc;
    public int duration;
    public boolean mAutoPlay;
    public boolean mLoop;
    public String mPlayerId;
    public int mPos;
    public String mSrc;

    public static b a(JSONObject jSONObject, @NonNull b bVar) {
        b bVar2 = new b();
        if (jSONObject != null) {
            bVar2.updateFromJson(jSONObject, bVar);
            bVar2.mPlayerId = jSONObject.optString("videoId", bVar.mPlayerId);
            bVar2.mAutoPlay = jSONObject.optBoolean("autoplay", bVar.mAutoPlay);
            bVar2.bES = jSONObject.optBoolean("muted", bVar.bES);
            bVar2.bEA = jSONObject.optString("objectFit", bVar.bEA);
            bVar2.bEU = jSONObject.optInt("initialTime", bVar.bEU);
            bVar2.bET = jSONObject.optString("poster", bVar.bET);
            bVar2.mPos = jSONObject.optInt(AiAppsNaViewModel.KEY_POSITION, bVar.mPos);
            bVar2.bEB = jSONObject.optBoolean("fullScreen", bVar.bEB);
            bVar2.bEV = M(jSONObject);
            bVar2.bEW = jSONObject.optString("danmuList", bVar.bEW);
            bVar2.bEX = jSONObject.optBoolean("enableDanmu", bVar.bEX);
            bVar2.bEY = jSONObject.optBoolean("danmuBtn", bVar.bEY);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.bEZ = jSONObject.optBoolean("controls", bVar.bEZ);
            bVar2.mSrc = kk(jSONObject.optString(ImageCoverViewModel.KEY_SRC, bVar.mSrc));
            bVar2.bFa = jSONObject.optBoolean("showPlayBtn", bVar.bFa);
            bVar2.bFb = jSONObject.optBoolean("showMuteBtn", bVar.bFb);
            bVar2.bFc = jSONObject.optBoolean("showCenterPlayBtn", bVar.bFc);
        }
        return bVar2;
    }

    public b() {
        super("viewId", "video");
        this.mPlayerId = "";
        this.bES = false;
        this.bET = "";
        this.bEU = 0;
        this.duration = 0;
        this.mAutoPlay = false;
        this.mLoop = false;
        this.bEA = "";
        this.mPos = 0;
        this.bEV = "";
        this.bEW = "";
        this.bEX = false;
        this.bEY = false;
        this.bEZ = true;
        this.mSrc = "";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return !TextUtils.isEmpty(this.mPlayerId);
    }

    public boolean isAutoPlay() {
        return this.mAutoPlay;
    }

    private static String M(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("text", jSONObject.optString("text"));
            jSONObject2.putOpt("color", jSONObject.optString("color"));
            jSONObject2.putOpt("videoId", jSONObject.optString("videoId"));
        } catch (JSONException e) {
        }
        return jSONObject2.toString();
    }

    private static String kk(String str) {
        return (!StorageUtil.isLocalFileScheme(str) || AiApp.get() == null) ? str : StorageUtil.obtainPathFromScheme(str, AiApp.get());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bES + "', mObjectFit='" + this.bEA + "', mControl=" + this.bEZ + '}';
    }
}
