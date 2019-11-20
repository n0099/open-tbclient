package com.baidu.tieba.ala.liveroom.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class b {
    boolean egI = false;
    String date = "";
    int dNf = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.egI);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.dNf);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
