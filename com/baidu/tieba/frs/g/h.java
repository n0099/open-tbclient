package com.baidu.tieba.frs.g;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    public String forumName;
    public long lastTime;

    public h() {
    }

    public h(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.lastTime = jSONObject.optLong("last_time");
    }

    public JSONObject agU() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("last_time", this.lastTime);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
