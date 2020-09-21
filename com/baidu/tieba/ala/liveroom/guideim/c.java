package com.baidu.tieba.ala.liveroom.guideim;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class c {
    boolean gEg = false;
    String date = "";
    int dgo = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasInput", this.gEg);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.dgo);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
