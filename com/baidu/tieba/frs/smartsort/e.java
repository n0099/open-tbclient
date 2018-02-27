package com.baidu.tieba.frs.smartsort;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public long dTQ;
    public String forumName;

    public e() {
    }

    public e(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.dTQ = jSONObject.optLong("last_time");
    }

    public JSONObject azP() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("last_time", this.dTQ);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
