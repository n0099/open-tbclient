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
    public String bJF;
    public boolean bJG;
    public boolean bJX;
    public String bJY;
    public int bJZ;
    public String bKa;
    public String bKb;
    public boolean bKc;
    public boolean bKd;
    public boolean bKe;
    private boolean bKf;
    private boolean bKg;
    private boolean bKh;
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
            bVar2.bJX = jSONObject.optBoolean("muted", bVar.bJX);
            bVar2.bJF = jSONObject.optString("objectFit", bVar.bJF);
            bVar2.bJZ = jSONObject.optInt("initialTime", bVar.bJZ);
            bVar2.bJY = jSONObject.optString("poster", bVar.bJY);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.bJG = jSONObject.optBoolean("fullScreen", bVar.bJG);
            bVar2.bKa = N(jSONObject);
            bVar2.bKb = jSONObject.optString("danmuList", bVar.bKb);
            bVar2.bKc = jSONObject.optBoolean("enableDanmu", bVar.bKc);
            bVar2.bKd = jSONObject.optBoolean("danmuBtn", bVar.bKd);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.bKe = jSONObject.optBoolean("controls", bVar.bKe);
            bVar2.mSrc = kX(jSONObject.optString(ImageCoverViewModel.KEY_SRC, bVar.mSrc));
            bVar2.bKf = jSONObject.optBoolean("showPlayBtn", bVar.bKf);
            bVar2.bKg = jSONObject.optBoolean("showMuteBtn", bVar.bKg);
            bVar2.bKh = jSONObject.optBoolean("showCenterPlayBtn", bVar.bKh);
        }
        return bVar2;
    }

    public b() {
        super("viewId", "video");
        this.mPlayerId = "";
        this.bJX = false;
        this.bJY = "";
        this.bJZ = 0;
        this.duration = 0;
        this.mAutoPlay = false;
        this.mLoop = false;
        this.bJF = "";
        this.mPos = 0;
        this.bKa = "";
        this.bKb = "";
        this.bKc = false;
        this.bKd = false;
        this.bKe = true;
        this.mSrc = "";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return !TextUtils.isEmpty(this.mPlayerId);
    }

    public boolean isAutoPlay() {
        return this.mAutoPlay;
    }

    private static String N(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("text", jSONObject.optString("text"));
            jSONObject2.putOpt("color", jSONObject.optString("color"));
            jSONObject2.putOpt("videoId", jSONObject.optString("videoId"));
        } catch (JSONException e) {
        }
        return jSONObject2.toString();
    }

    private static String kX(String str) {
        return (!StorageUtil.isLocalFileScheme(str) || AiApp.get() == null) ? str : StorageUtil.obtainPathFromScheme(str, AiApp.get());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bJX + "', mObjectFit='" + this.bJF + "', mControl=" + this.bKe + '}';
    }
}
