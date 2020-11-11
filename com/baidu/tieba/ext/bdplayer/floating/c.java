package com.baidu.tieba.ext.bdplayer.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject gBD;
    private JSONObject gBI;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject ctR() {
        return this.gBD;
    }

    public JSONObject ctS() {
        return this.gBI;
    }

    public static c JB(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        return dX(jSONObject);
    }

    public static c dX(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.gBD = jSONObject.optJSONObject("extra");
        cVar.gBI = jSONObject.optJSONObject("src");
        try {
            JSONObject ctS = cVar.ctS();
            if (ctS != null) {
                cVar.roomId = ctS.optString("room_id");
                cVar.cover = ctS.optString("cover");
            }
            JSONObject ctR = cVar.ctR();
            if (ctR != null) {
                cVar.extra = ctR.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
