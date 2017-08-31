package com.baidu.tieba.frs.smartsort;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public String forumName;
    public long lastTime;

    public e() {
    }

    public e(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.lastTime = jSONObject.optLong("last_time");
    }

    public JSONObject ali() {
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
