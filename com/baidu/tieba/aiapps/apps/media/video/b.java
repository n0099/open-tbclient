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
    public boolean bFE;
    public String bFF;
    public int bFG;
    public String bFH;
    public String bFI;
    public boolean bFJ;
    public boolean bFK;
    public boolean bFL;
    private boolean bFM;
    private boolean bFN;
    private boolean bFO;
    public String bFm;
    public boolean bFn;
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
            bVar2.bFE = jSONObject.optBoolean("muted", bVar.bFE);
            bVar2.bFm = jSONObject.optString("objectFit", bVar.bFm);
            bVar2.bFG = jSONObject.optInt("initialTime", bVar.bFG);
            bVar2.bFF = jSONObject.optString("poster", bVar.bFF);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.bFn = jSONObject.optBoolean("fullScreen", bVar.bFn);
            bVar2.bFH = M(jSONObject);
            bVar2.bFI = jSONObject.optString("danmuList", bVar.bFI);
            bVar2.bFJ = jSONObject.optBoolean("enableDanmu", bVar.bFJ);
            bVar2.bFK = jSONObject.optBoolean("danmuBtn", bVar.bFK);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.bFL = jSONObject.optBoolean("controls", bVar.bFL);
            bVar2.mSrc = km(jSONObject.optString(ImageCoverViewModel.KEY_SRC, bVar.mSrc));
            bVar2.bFM = jSONObject.optBoolean("showPlayBtn", bVar.bFM);
            bVar2.bFN = jSONObject.optBoolean("showMuteBtn", bVar.bFN);
            bVar2.bFO = jSONObject.optBoolean("showCenterPlayBtn", bVar.bFO);
        }
        return bVar2;
    }

    public b() {
        super("viewId", "video");
        this.mPlayerId = "";
        this.bFE = false;
        this.bFF = "";
        this.bFG = 0;
        this.duration = 0;
        this.mAutoPlay = false;
        this.mLoop = false;
        this.bFm = "";
        this.mPos = 0;
        this.bFH = "";
        this.bFI = "";
        this.bFJ = false;
        this.bFK = false;
        this.bFL = true;
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

    private static String km(String str) {
        return (!StorageUtil.isLocalFileScheme(str) || AiApp.get() == null) ? str : StorageUtil.obtainPathFromScheme(str, AiApp.get());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bFE + "', mObjectFit='" + this.bFm + "', mControl=" + this.bFL + '}';
    }
}
