package com.baidu.tieba.ala.liveroom.n;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
class b {
    boolean gAz = false;
    String date = "";
    int dej = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.gAz);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.dej);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
