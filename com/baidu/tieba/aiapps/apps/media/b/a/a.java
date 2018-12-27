package com.baidu.tieba.aiapps.apps.media.b.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    public int bJg;
    public int bJh;
    public int bJi;
    public int bJj;
    public int mVideoHeight;
    public int mVideoWidth;

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("videoBitrate", this.bJg);
            jSONObject2.put("audioBitrate", this.bJh);
            jSONObject2.put("videoFPS", this.bJi);
            jSONObject2.put("netSpeed", this.bJj);
            jSONObject2.put("videoWidth", this.mVideoWidth);
            jSONObject2.put("videoHeight", this.mVideoHeight);
            jSONObject.putOpt("detail", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
