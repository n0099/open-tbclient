package com.baidu.tieba.ext.bdplayer.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject gBk;
    private JSONObject gBp;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject ctu() {
        return this.gBk;
    }

    public JSONObject ctv() {
        return this.gBp;
    }

    public static c Jc(String str) {
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
        cVar.gBk = jSONObject.optJSONObject("extra");
        cVar.gBp = jSONObject.optJSONObject("src");
        try {
            JSONObject ctv = cVar.ctv();
            if (ctv != null) {
                cVar.roomId = ctv.optString("room_id");
                cVar.cover = ctv.optString("cover");
            }
            JSONObject ctu = cVar.ctu();
            if (ctu != null) {
                cVar.extra = ctu.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
