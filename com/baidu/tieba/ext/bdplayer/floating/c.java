package com.baidu.tieba.ext.bdplayer.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    private JSONObject fWf;
    private JSONObject fWk;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject chy() {
        return this.fWf;
    }

    public JSONObject chz() {
        return this.fWk;
    }

    public static c HB(String str) {
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
        cVar.fWf = jSONObject.optJSONObject("extra");
        cVar.fWk = jSONObject.optJSONObject("src");
        try {
            JSONObject chz = cVar.chz();
            if (chz != null) {
                cVar.roomId = chz.optString("room_id");
                cVar.cover = chz.optString("cover");
            }
            JSONObject chy = cVar.chy();
            if (chy != null) {
                cVar.extra = chy.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
