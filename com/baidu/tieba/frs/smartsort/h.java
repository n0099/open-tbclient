package com.baidu.tieba.frs.smartsort;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    public int cak;
    public String forumName;

    public h() {
    }

    public h(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.cak = jSONObject.optInt("sort_tabId");
    }

    public JSONObject adu() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("sort_tabId", this.cak);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
