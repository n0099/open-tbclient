package com.baidu.tieba.ext.bdplayer.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject glK;
    private JSONObject glP;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject coj() {
        return this.glK;
    }

    public JSONObject cok() {
        return this.glP;
    }

    public static c IL(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        return dL(jSONObject);
    }

    public static c dL(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.glK = jSONObject.optJSONObject("extra");
        cVar.glP = jSONObject.optJSONObject("src");
        try {
            JSONObject cok = cVar.cok();
            if (cok != null) {
                cVar.roomId = cok.optString("room_id");
                cVar.cover = cok.optString("cover");
            }
            JSONObject coj = cVar.coj();
            if (coj != null) {
                cVar.extra = coj.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
