package com.baidu.tieba.ala.liveroom.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class b {
    boolean ehz = false;
    String date = "";
    int dNW = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.ehz);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.dNW);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
