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

    public JSONObject cAD() {
        return this.gVV;
    }

    public JSONObject cAE() {
        return this.gWa;
    }

    public static c JQ(String str) {
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
            JSONObject cAE = cVar.cAE();
            if (cAE != null) {
                cVar.roomId = cAE.optString("room_id");
                cVar.cover = cAE.optString("cover");
            }
            JSONObject cAD = cVar.cAD();
            if (cAD != null) {
                cVar.extra = cAD.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
