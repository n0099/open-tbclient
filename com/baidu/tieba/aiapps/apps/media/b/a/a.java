package com.baidu.tieba.aiapps.apps.media.b.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    public int bJT;
    public int bJU;
    public int bJV;
    public int bJW;
    public int mVideoHeight;
    public int mVideoWidth;

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("videoBitrate", this.bJT);
            jSONObject2.put("audioBitrate", this.bJU);
            jSONObject2.put("videoFPS", this.bJV);
            jSONObject2.put("netSpeed", this.bJW);
            jSONObject2.put("videoWidth", this.mVideoWidth);
            jSONObject2.put("videoHeight", this.mVideoHeight);
            jSONObject.putOpt("detail", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
