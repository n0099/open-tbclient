package com.baidu.tieba.aiapps.apps.media.b.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    public int bJd;
    public int bJe;
    public int bJf;
    public int bJg;
    public int mVideoHeight;
    public int mVideoWidth;

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("videoBitrate", this.bJd);
            jSONObject2.put("audioBitrate", this.bJe);
            jSONObject2.put("videoFPS", this.bJf);
            jSONObject2.put("netSpeed", this.bJg);
            jSONObject2.put("videoWidth", this.mVideoWidth);
            jSONObject2.put("videoHeight", this.mVideoHeight);
            jSONObject.putOpt("detail", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
