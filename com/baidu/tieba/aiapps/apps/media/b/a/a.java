package com.baidu.tieba.aiapps.apps.media.b.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    public int cVA;
    public int cVx;
    public int cVy;
    public int cVz;
    public int mVideoHeight;
    public int mVideoWidth;

    public String EI() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("videoBitrate", this.cVx);
            jSONObject2.put("audioBitrate", this.cVy);
            jSONObject2.put("videoFPS", this.cVz);
            jSONObject2.put("netSpeed", this.cVA);
            jSONObject2.put("videoWidth", this.mVideoWidth);
            jSONObject2.put("videoHeight", this.mVideoHeight);
            jSONObject.putOpt("detail", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e));
            }
            return null;
        }
    }
}
