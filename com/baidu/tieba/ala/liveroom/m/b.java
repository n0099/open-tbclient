package com.baidu.tieba.ala.liveroom.m;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class b {
    boolean gnJ = false;
    String date = "";
    int cVg = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.gnJ);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.cVg);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
