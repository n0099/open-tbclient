package com.baidu.tieba.ala.liveroom.o;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class c {
    boolean hjX = false;
    String date = "";
    int dGM = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.hjX);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.dGM);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
