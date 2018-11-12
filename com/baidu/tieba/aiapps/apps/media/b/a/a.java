package com.baidu.tieba.aiapps.apps.media.b.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    public int bFA;
    public int bFB;
    public int bFC;
    public int bFD;
    public int mVideoHeight;
    public int mVideoWidth;

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("videoBitrate", this.bFA);
            jSONObject2.put("audioBitrate", this.bFB);
            jSONObject2.put("videoFPS", this.bFC);
            jSONObject2.put("netSpeed", this.bFD);
            jSONObject2.put("videoWidth", this.mVideoWidth);
            jSONObject2.put("videoHeight", this.mVideoHeight);
            jSONObject.putOpt("detail", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
