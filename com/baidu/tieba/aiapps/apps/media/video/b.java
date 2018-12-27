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
    public String bIS;
    public boolean bIT;
    public boolean bJk;
    public String bJl;
    public int bJm;
    public String bJn;
    public String bJo;
    public boolean bJp;
    public boolean bJq;
    public boolean bJr;
    private boolean bJs;
    private boolean bJt;
    private boolean bJu;
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
            bVar2.bJk = jSONObject.optBoolean("muted", bVar.bJk);
            bVar2.bIS = jSONObject.optString("objectFit", bVar.bIS);
            bVar2.bJm = jSONObject.optInt("initialTime", bVar.bJm);
            bVar2.bJl = jSONObject.optString("poster", bVar.bJl);
            bVar2.mPos = jSONObject.optInt("position", bVar.mPos);
            bVar2.bIT = jSONObject.optBoolean("fullScreen", bVar.bIT);
            bVar2.bJn = N(jSONObject);
            bVar2.bJo = jSONObject.optString("danmuList", bVar.bJo);
            bVar2.bJp = jSONObject.optBoolean("enableDanmu", bVar.bJp);
            bVar2.bJq = jSONObject.optBoolean("danmuBtn", bVar.bJq);
            bVar2.mLoop = jSONObject.optBoolean("loop", bVar.mLoop);
            bVar2.bJr = jSONObject.optBoolean("controls", bVar.bJr);
            bVar2.mSrc = kH(jSONObject.optString(ImageCoverViewModel.KEY_SRC, bVar.mSrc));
            bVar2.bJs = jSONObject.optBoolean("showPlayBtn", bVar.bJs);
            bVar2.bJt = jSONObject.optBoolean("showMuteBtn", bVar.bJt);
            bVar2.bJu = jSONObject.optBoolean("showCenterPlayBtn", bVar.bJu);
        }
        return bVar2;
    }

    public b() {
        super("viewId", "video");
        this.mPlayerId = "";
        this.bJk = false;
        this.bJl = "";
        this.bJm = 0;
        this.duration = 0;
        this.mAutoPlay = false;
        this.mLoop = false;
        this.bIS = "";
        this.mPos = 0;
        this.bJn = "";
        this.bJo = "";
        this.bJp = false;
        this.bJq = false;
        this.bJr = true;
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

    private static String kH(String str) {
        return (!StorageUtil.isLocalFileScheme(str) || AiApp.get() == null) ? str : StorageUtil.obtainPathFromScheme(str, AiApp.get());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.mPlayerId + "', mSlaveId='" + this.slaveId + "', mMuted=" + this.bJk + "', mObjectFit='" + this.bIS + "', mControl=" + this.bJr + '}';
    }
}
