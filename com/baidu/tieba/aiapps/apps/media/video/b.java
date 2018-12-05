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
    public String bIP;
    public boolean bIQ;
    public boolean bJh;
    public String bJi;
    public int bJj;
    public String bJk;
    public String bJl;
    public boolean bJm;
    public boolean bJn;
    public boolean bJo;
    private boolean bJp;
    private boolean bJq;
    private boolean bJr;
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
            bVar2.bJh = jSONObject.optBoolean("muted", bVar.bJh);
            bVar2.bIP = jSONObject.optString("objectFit", bVar.bIP);
            bVar2.bJj = jSONObject.optInt("initialTime", bVar.bJj);
            bVar2.bJi = jSONObject.optString("poster", bVar.bJi);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.bIQ = jSONObject.optBoolean("fullScreen", bVar.bIQ);
            bVar2.bJk = N(jSONObject);
            bVar2.bJl = jSONObject.optString("danmuList", bVar.bJl);
            bVar2.bJm = jSONObject.optBoolean("enableDanmu", bVar.bJm);
            bVar2.bJn = jSONObject.optBoolean("danmuBtn", bVar.bJn);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.bJo = jSONObject.optBoolean("controls", bVar.bJo);
            bVar2.mSrc = kG(jSONObject.optString(ImageCoverViewModel.KEY_SRC, bVar.mSrc));
            bVar2.bJp = jSONObject.optBoolean("showPlayBtn", bVar.bJp);
            bVar2.bJq = jSONObject.optBoolean("showMuteBtn", bVar.bJq);
            bVar2.bJr = jSONObject.optBoolean("showCenterPlayBtn", bVar.bJr);
        }
        return bVar2;
    }

    public b() {
        super("viewId", "video");
        this.mPlayerId = "";
        this.bJh = false;
        this.bJi = "";
        this.bJj = 0;
        this.duration = 0;
        this.mAutoPlay = false;
        this.mLoop = false;
        this.bIP = "";
        this.mPos = 0;
        this.bJk = "";
        this.bJl = "";
        this.bJm = false;
        this.bJn = false;
        this.bJo = true;
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

    private static String kG(String str) {
        return (!StorageUtil.isLocalFileScheme(str) || AiApp.get() == null) ? str : StorageUtil.obtainPathFromScheme(str, AiApp.get());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bJh + "', mObjectFit='" + this.bIP + "', mControl=" + this.bJo + '}';
    }
}
