package com.baidu.tieba.aiapps.apps.media.video;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean azC;
    public String azs;
    public String cVA;
    public int cVB;
    public String cVC;
    public String cVD;
    public boolean cVE;
    public boolean cVF;
    public boolean cVG;
    private boolean cVH;
    private boolean cVI;
    private boolean cVJ;
    public String cVe;
    public boolean cVf;
    public boolean cVz;
    public int duration;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) cVar);
            cVar2.azs = jSONObject.optString("videoId", cVar.azs);
            cVar2.azC = jSONObject.optBoolean("autoplay", cVar.azC);
            cVar2.cVz = jSONObject.optBoolean("muted", cVar.cVz);
            cVar2.cVe = jSONObject.optString("objectFit", cVar.cVe);
            cVar2.cVB = jSONObject.optInt("initialTime", cVar.cVB);
            cVar2.cVA = jSONObject.optString("poster", cVar.cVA);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cVf = jSONObject.optBoolean("fullScreen", cVar.cVf);
            cVar2.cVC = aW(jSONObject);
            cVar2.cVD = jSONObject.optString("danmuList", cVar.cVD);
            cVar2.cVE = jSONObject.optBoolean("enableDanmu", cVar.cVE);
            cVar2.cVF = jSONObject.optBoolean("danmuBtn", cVar.cVF);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cVG = jSONObject.optBoolean("controls", cVar.cVG);
            cVar2.mSrc = rE(jSONObject.optString("src", cVar.mSrc));
            cVar2.cVH = jSONObject.optBoolean("showPlayBtn", cVar.cVH);
            cVar2.cVI = jSONObject.optBoolean("showMuteBtn", cVar.cVI);
            cVar2.cVJ = jSONObject.optBoolean("showCenterPlayBtn", cVar.cVJ);
            cVar2.cVG = cVar2.cVG || cVar2.cVH;
        }
        return cVar2;
    }

    public c() {
        super("viewId", "video");
        this.azs = "";
        this.cVz = false;
        this.cVA = "";
        this.cVB = 0;
        this.duration = 0;
        this.azC = false;
        this.mLoop = false;
        this.cVe = "";
        this.mPos = 0;
        this.cVC = "";
        this.cVD = "";
        this.cVE = false;
        this.cVF = false;
        this.cVG = true;
        this.mSrc = "";
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.azs);
    }

    public boolean isAutoPlay() {
        return this.azC;
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

    private static String rE(String str) {
        return (!com.baidu.swan.apps.storage.b.gV(str) || com.baidu.swan.apps.ae.b.IX() == null) ? str : com.baidu.swan.apps.storage.b.b(str, com.baidu.swan.apps.ae.b.IX());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.azs + "', mSlaveId='" + this.aBD + "', mMuted=" + this.cVz + "', mObjectFit='" + this.cVe + "', mControl=" + this.cVG + '}';
    }
}
