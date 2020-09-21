package com.baidu.tieba.ext.bdplayer.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject fZs;
    private JSONObject fZx;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject ckM() {
        return this.fZs;
    }

    public JSONObject ckN() {
        return this.fZx;
    }

    public static c HY(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        return dH(jSONObject);
    }

    public static c dH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.fZs = jSONObject.optJSONObject("extra");
        cVar.fZx = jSONObject.optJSONObject("src");
        try {
            JSONObject ckN = cVar.ckN();
            if (ckN != null) {
                cVar.roomId = ckN.optString("room_id");
                cVar.cover = ckN.optString("cover");
            }
            JSONObject ckM = cVar.ckM();
            if (ckM != null) {
                cVar.extra = ckM.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
