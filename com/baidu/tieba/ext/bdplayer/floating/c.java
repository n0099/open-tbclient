package com.baidu.tieba.ext.bdplayer.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject gvP;
    private JSONObject gvU;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject crq() {
        return this.gvP;
    }

    public JSONObject crr() {
        return this.gvU;
    }

    public static c Jk(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        return dR(jSONObject);
    }

    public static c dR(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.gvP = jSONObject.optJSONObject("extra");
        cVar.gvU = jSONObject.optJSONObject("src");
        try {
            JSONObject crr = cVar.crr();
            if (crr != null) {
                cVar.roomId = crr.optString("room_id");
                cVar.cover = crr.optString("cover");
            }
            JSONObject crq = cVar.crq();
            if (crq != null) {
                cVar.extra = crq.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
