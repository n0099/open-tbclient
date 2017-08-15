package com.baidu.tieba.frs.smartsort;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public int cxD;
    public String forumName;

    public f() {
    }

    public f(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.cxD = jSONObject.optInt("sort_tabId");
    }

    public JSONObject ajE() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("sort_tabId", this.cxD);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
