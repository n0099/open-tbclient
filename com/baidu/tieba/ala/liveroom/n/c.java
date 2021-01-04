package com.baidu.tieba.ala.liveroom.n;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
class c {
    boolean hFa = false;
    String date = "";
    int bsA = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.hFa);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.bsA);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
