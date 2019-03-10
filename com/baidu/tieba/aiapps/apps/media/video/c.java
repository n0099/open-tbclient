package com.baidu.tieba.aiapps.apps.media.video;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public boolean azB;
    public String azr;
    public boolean cVD;
    public String cVE;
    public int cVF;
    public String cVG;
    public String cVH;
    public boolean cVI;
    public boolean cVJ;
    public boolean cVK;
    private boolean cVL;
    private boolean cVM;
    private boolean cVN;
    public String cVi;
    public boolean cVj;
    public int duration;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) cVar);
            cVar2.azr = jSONObject.optString("videoId", cVar.azr);
            cVar2.azB = jSONObject.optBoolean("autoplay", cVar.azB);
            cVar2.cVD = jSONObject.optBoolean("muted", cVar.cVD);
            cVar2.cVi = jSONObject.optString("objectFit", cVar.cVi);
            cVar2.cVF = jSONObject.optInt("initialTime", cVar.cVF);
            cVar2.cVE = jSONObject.optString("poster", cVar.cVE);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cVj = jSONObject.optBoolean("fullScreen", cVar.cVj);
            cVar2.cVG = aW(jSONObject);
            cVar2.cVH = jSONObject.optString("danmuList", cVar.cVH);
            cVar2.cVI = jSONObject.optBoolean("enableDanmu", cVar.cVI);
            cVar2.cVJ = jSONObject.optBoolean("danmuBtn", cVar.cVJ);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cVK = jSONObject.optBoolean("controls", cVar.cVK);
            cVar2.mSrc = rG(jSONObject.optString("src", cVar.mSrc));
            cVar2.cVL = jSONObject.optBoolean("showPlayBtn", cVar.cVL);
            cVar2.cVM = jSONObject.optBoolean("showMuteBtn", cVar.cVM);
            cVar2.cVN = jSONObject.optBoolean("showCenterPlayBtn", cVar.cVN);
            cVar2.cVK = cVar2.cVK || cVar2.cVL;
        }
        return cVar2;
    }

    public c() {
        super("viewId", "video");
        this.azr = "";
        this.cVD = false;
        this.cVE = "";
        this.cVF = 0;
        this.duration = 0;
        this.azB = false;
        this.mLoop = false;
        this.cVi = "";
        this.mPos = 0;
        this.cVG = "";
        this.cVH = "";
        this.cVI = false;
        this.cVJ = false;
        this.cVK = true;
        this.mSrc = "";
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.azr);
    }

    public boolean isAutoPlay() {
        return this.azB;
    }

    private static String aW(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("text", jSONObject.optString("text"));
            jSONObject2.putOpt("color", jSONObject.optString("color"));
            jSONObject2.putOpt("videoId", jSONObject.optString("videoId"));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject2.toString();
    }

    private static String rG(String str) {
        return (!com.baidu.swan.apps.storage.b.gV(str) || com.baidu.swan.apps.ae.b.IX() == null) ? str : com.baidu.swan.apps.storage.b.b(str, com.baidu.swan.apps.ae.b.IX());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.azr + "', mSlaveId='" + this.aBC + "', mMuted=" + this.cVD + "', mObjectFit='" + this.cVi + "', mControl=" + this.cVK + '}';
    }
}
