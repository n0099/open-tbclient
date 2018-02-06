package com.baidu.tieba.frs.smartsort;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public long dUc;
    public String forumName;

    public e() {
    }

    public e(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.dUc = jSONObject.optLong("last_time");
    }

    public JSONObject azQ() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("last_time", this.dUc);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
