package com.baidu.tieba.ala.liveroom.guideim;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class c {
    boolean hts = false;
    String date = "";
    int dMd = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasInput", this.hts);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.dMd);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
