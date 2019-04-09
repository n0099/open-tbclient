package com.baidu.tieba.aiapps.apps.media.video;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean azG;
    public String azw;
    public boolean cVC;
    public String cVD;
    public int cVE;
    public String cVF;
    public String cVG;
    public boolean cVH;
    public boolean cVI;
    public boolean cVJ;
    private boolean cVK;
    private boolean cVL;
    private boolean cVM;
    public String cVh;
    public boolean cVi;
    public int duration;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) cVar);
            cVar2.azw = jSONObject.optString("videoId", cVar.azw);
            cVar2.azG = jSONObject.optBoolean("autoplay", cVar.azG);
            cVar2.cVC = jSONObject.optBoolean("muted", cVar.cVC);
            cVar2.cVh = jSONObject.optString("objectFit", cVar.cVh);
            cVar2.cVE = jSONObject.optInt("initialTime", cVar.cVE);
            cVar2.cVD = jSONObject.optString("poster", cVar.cVD);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cVi = jSONObject.optBoolean("fullScreen", cVar.cVi);
            cVar2.cVF = aW(jSONObject);
            cVar2.cVG = jSONObject.optString("danmuList", cVar.cVG);
            cVar2.cVH = jSONObject.optBoolean("enableDanmu", cVar.cVH);
            cVar2.cVI = jSONObject.optBoolean("danmuBtn", cVar.cVI);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cVJ = jSONObject.optBoolean("controls", cVar.cVJ);
            cVar2.mSrc = rF(jSONObject.optString("src", cVar.mSrc));
            cVar2.cVK = jSONObject.optBoolean("showPlayBtn", cVar.cVK);
            cVar2.cVL = jSONObject.optBoolean("showMuteBtn", cVar.cVL);
            cVar2.cVM = jSONObject.optBoolean("showCenterPlayBtn", cVar.cVM);
            cVar2.cVJ = cVar2.cVJ || cVar2.cVK;
        }
        return cVar2;
    }

    public c() {
        super("viewId", "video");
        this.azw = "";
        this.cVC = false;
        this.cVD = "";
        this.cVE = 0;
        this.duration = 0;
        this.azG = false;
        this.mLoop = false;
        this.cVh = "";
        this.mPos = 0;
        this.cVF = "";
        this.cVG = "";
        this.cVH = false;
        this.cVI = false;
        this.cVJ = true;
        this.mSrc = "";
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.azw);
    }

    public boolean isAutoPlay() {
        return this.azG;
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
        return "VideoPlayerParams{mPlayerId='" + this.azw + "', mSlaveId='" + this.aBH + "', mMuted=" + this.cVC + "', mObjectFit='" + this.cVh + "', mControl=" + this.cVJ + '}';
    }
}
