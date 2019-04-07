package com.baidu.tieba.aiapps.apps.media.video;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean azF;
    public String azv;
    public boolean cVB;
    public String cVC;
    public int cVD;
    public String cVE;
    public String cVF;
    public boolean cVG;
    public boolean cVH;
    public boolean cVI;
    private boolean cVJ;
    private boolean cVK;
    private boolean cVL;
    public String cVg;
    public boolean cVh;
    public int duration;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) cVar);
            cVar2.azv = jSONObject.optString("videoId", cVar.azv);
            cVar2.azF = jSONObject.optBoolean("autoplay", cVar.azF);
            cVar2.cVB = jSONObject.optBoolean("muted", cVar.cVB);
            cVar2.cVg = jSONObject.optString("objectFit", cVar.cVg);
            cVar2.cVD = jSONObject.optInt("initialTime", cVar.cVD);
            cVar2.cVC = jSONObject.optString("poster", cVar.cVC);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cVh = jSONObject.optBoolean("fullScreen", cVar.cVh);
            cVar2.cVE = aW(jSONObject);
            cVar2.cVF = jSONObject.optString("danmuList", cVar.cVF);
            cVar2.cVG = jSONObject.optBoolean("enableDanmu", cVar.cVG);
            cVar2.cVH = jSONObject.optBoolean("danmuBtn", cVar.cVH);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cVI = jSONObject.optBoolean("controls", cVar.cVI);
            cVar2.mSrc = rF(jSONObject.optString("src", cVar.mSrc));
            cVar2.cVJ = jSONObject.optBoolean("showPlayBtn", cVar.cVJ);
            cVar2.cVK = jSONObject.optBoolean("showMuteBtn", cVar.cVK);
            cVar2.cVL = jSONObject.optBoolean("showCenterPlayBtn", cVar.cVL);
            cVar2.cVI = cVar2.cVI || cVar2.cVJ;
        }
        return cVar2;
    }

    public c() {
        super("viewId", "video");
        this.azv = "";
        this.cVB = false;
        this.cVC = "";
        this.cVD = 0;
        this.duration = 0;
        this.azF = false;
        this.mLoop = false;
        this.cVg = "";
        this.mPos = 0;
        this.cVE = "";
        this.cVF = "";
        this.cVG = false;
        this.cVH = false;
        this.cVI = true;
        this.mSrc = "";
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.azv);
    }

    public boolean isAutoPlay() {
        return this.azF;
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

    private static String rF(String str) {
        return (!com.baidu.swan.apps.storage.b.gW(str) || com.baidu.swan.apps.ae.b.IV() == null) ? str : com.baidu.swan.apps.storage.b.b(str, com.baidu.swan.apps.ae.b.IV());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.azv + "', mSlaveId='" + this.aBG + "', mMuted=" + this.cVB + "', mObjectFit='" + this.cVg + "', mControl=" + this.cVI + '}';
    }
}
