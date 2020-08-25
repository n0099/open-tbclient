package com.baidu.tieba.ala.liveroom.guideim;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
class c {
    boolean gAN = false;
    String date = "";
    int dej = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasInput", this.gAN);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.dej);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
