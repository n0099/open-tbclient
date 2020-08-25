package com.baidu.tieba.ext.bdplayer.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    private JSONObject fWb;
    private JSONObject fWg;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject chx() {
        return this.fWb;
    }

    public JSONObject chy() {
        return this.fWg;
    }

    public static c HA(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        return dz(jSONObject);
    }

    public static c dz(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.fWb = jSONObject.optJSONObject("extra");
        cVar.fWg = jSONObject.optJSONObject("src");
        try {
            JSONObject chy = cVar.chy();
            if (chy != null) {
                cVar.roomId = chy.optString("room_id");
                cVar.cover = chy.optString("cover");
            }
            JSONObject chx = cVar.chx();
            if (chx != null) {
                cVar.extra = chx.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
