package com.baidu.tieba.ala.liveroom.n;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class c {
    boolean htc = false;
    String date = "";
    int dMd = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.htc);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.dMd);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
