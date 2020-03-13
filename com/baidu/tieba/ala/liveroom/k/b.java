package com.baidu.tieba.ala.liveroom.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class b {
    boolean fcV = false;
    String date = "";
    int eGV = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.fcV);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.eGV);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
