package com.baidu.tieba.aiapps.apps.media.b.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    public int bEO;
    public int bEP;
    public int bEQ;
    public int bER;
    public int mVideoHeight;
    public int mVideoWidth;

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("videoBitrate", this.bEO);
            jSONObject2.put("audioBitrate", this.bEP);
            jSONObject2.put("videoFPS", this.bEQ);
            jSONObject2.put("netSpeed", this.bER);
            jSONObject2.put("videoWidth", this.mVideoWidth);
            jSONObject2.put("videoHeight", this.mVideoHeight);
            jSONObject.putOpt("detail", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
