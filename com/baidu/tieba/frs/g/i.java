package com.baidu.tieba.frs.g;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public int chb;
    public String forumName;

    public i() {
    }

    public i(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.chb = jSONObject.optInt("sort_tabId");
    }

    public JSONObject agU() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("sort_tabId", this.chb);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
