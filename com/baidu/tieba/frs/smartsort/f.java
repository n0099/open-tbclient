package com.baidu.tieba.frs.smartsort;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public int dUd;
    public String forumName;

    public f() {
    }

    public f(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.dUd = jSONObject.optInt("sort_tabId");
    }

    public JSONObject azQ() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("sort_tabId", this.dUd);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
