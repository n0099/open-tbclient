package com.baidu.tieba.frs.smartsort;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    public int bSY;
    public String forumName;

    public h() {
    }

    public h(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.bSY = jSONObject.optInt("sort_tabId");
    }

    public JSONObject acw() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("sort_tabId", this.bSY);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
