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
    public String bJG;
    public boolean bJH;
    public boolean bJY;
    public String bJZ;
    public int bKa;
    public String bKb;
    public String bKc;
    public boolean bKd;
    public boolean bKe;
    public boolean bKf;
    private boolean bKg;
    private boolean bKh;
    private boolean bKi;
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
            bVar2.bJY = jSONObject.optBoolean("muted", bVar.bJY);
            bVar2.bJG = jSONObject.optString("objectFit", bVar.bJG);
            bVar2.bKa = jSONObject.optInt("initialTime", bVar.bKa);
            bVar2.bJZ = jSONObject.optString("poster", bVar.bJZ);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.bJH = jSONObject.optBoolean("fullScreen", bVar.bJH);
            bVar2.bKb = N(jSONObject);
            bVar2.bKc = jSONObject.optString("danmuList", bVar.bKc);
            bVar2.bKd = jSONObject.optBoolean("enableDanmu", bVar.bKd);
            bVar2.bKe = jSONObject.optBoolean("danmuBtn", bVar.bKe);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.bKf = jSONObject.optBoolean("controls", bVar.bKf);
            bVar2.mSrc = kX(jSONObject.optString(ImageCoverViewModel.KEY_SRC, bVar.mSrc));
            bVar2.bKg = jSONObject.optBoolean("showPlayBtn", bVar.bKg);
            bVar2.bKh = jSONObject.optBoolean("showMuteBtn", bVar.bKh);
            bVar2.bKi = jSONObject.optBoolean("showCenterPlayBtn", bVar.bKi);
        }
        return bVar2;
    }

    public b() {
        super("viewId", "video");
        this.mPlayerId = "";
        this.bJY = false;
        this.bJZ = "";
        this.bKa = 0;
        this.duration = 0;
        this.mAutoPlay = false;
        this.mLoop = false;
        this.bJG = "";
        this.mPos = 0;
        this.bKb = "";
        this.bKc = "";
        this.bKd = false;
        this.bKe = false;
        this.bKf = true;
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
        return "VideoPlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bJY + "', mObjectFit='" + this.bJG + "', mControl=" + this.bKf + '}';
    }
}
