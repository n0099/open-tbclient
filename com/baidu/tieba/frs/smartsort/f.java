package com.baidu.tieba.frs.smartsort;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public int cYN;
    public String forumName;

    public f() {
    }

    public f(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.cYN = jSONObject.optInt("sort_tabId");
    }

    public JSONObject aqv() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("sort_tabId", this.cYN);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
