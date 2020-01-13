package com.baidu.tieba.ala.liveroom.guideim;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class c {
    boolean eZH = false;
    String date = "";
    int eCy = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasInput", this.eZH);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.eCy);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
