package com.baidu.tieba.ala.liveroom.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class b {
    boolean fVD = false;
    String fzt = "";
    int fzu = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasShowMax", this.fVD);
            jSONObject.put("date", this.fzt);
            jSONObject.put("times", this.fzu);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
