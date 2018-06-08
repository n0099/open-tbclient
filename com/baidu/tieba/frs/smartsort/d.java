package com.baidu.tieba.frs.smartsort;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public long dyC;
    public String forumName;

    public d() {
    }

    public d(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.dyC = jSONObject.optLong("last_time");
    }

    public JSONObject ayP() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("last_time", this.dyC);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
