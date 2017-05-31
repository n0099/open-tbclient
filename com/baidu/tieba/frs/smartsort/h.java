package com.baidu.tieba.frs.smartsort;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    public int cfb;
    public String forumName;

    public h() {
    }

    public h(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.cfb = jSONObject.optInt("sort_tabId");
    }

    public JSONObject adv() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("sort_tabId", this.cfb);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
