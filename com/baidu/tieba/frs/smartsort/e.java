package com.baidu.tieba.frs.smartsort;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public long dTV;
    public String forumName;

    public e() {
    }

    public e(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.dTV = jSONObject.optLong("last_time");
    }

    public JSONObject azR() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("last_time", this.dTV);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
