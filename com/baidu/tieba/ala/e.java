package com.baidu.tieba.ala;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    boolean gqQ = false;
    String date = "";
    int brp = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasToast", this.gqQ);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.brp);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
