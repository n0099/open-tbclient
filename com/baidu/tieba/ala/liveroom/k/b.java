package com.baidu.tieba.ala.liveroom.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class b {
    boolean fHH = false;
    String date = "";
    int flN = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.fHH);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.flN);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
