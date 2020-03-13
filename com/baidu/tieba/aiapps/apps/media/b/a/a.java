package com.baidu.tieba.aiapps.apps.media.b.a;

import android.util.Log;
import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    public int aLa;
    public int aLg;
    public int eeC;
    public int eeD;
    public int mVideoHeight;
    public int mVideoWidth;

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("videoBitrate", this.aLa);
            jSONObject2.put("audioBitrate", this.aLg);
            jSONObject2.put("videoFPS", this.eeC);
            jSONObject2.put("netSpeed", this.eeD);
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
