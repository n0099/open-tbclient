package com.baidu.tieba.ext.bdplayer.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private JSONObject gVV;
    private JSONObject gWa;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject cAE() {
        return this.gVV;
    }

    public JSONObject cAF() {
        return this.gWa;
    }

    public static c JP(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        return eh(jSONObject);
    }

    public static c eh(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.gVV = jSONObject.optJSONObject("extra");
        cVar.gWa = jSONObject.optJSONObject("src");
        try {
            JSONObject cAF = cVar.cAF();
            if (cAF != null) {
                cVar.roomId = cAF.optString("room_id");
                cVar.cover = cAF.optString("cover");
            }
            JSONObject cAE = cVar.cAE();
            if (cAE != null) {
                cVar.extra = cAE.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
