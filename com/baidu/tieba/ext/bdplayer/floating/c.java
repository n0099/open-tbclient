package com.baidu.tieba.ext.bdplayer.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject gKj;
    private JSONObject gKo;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject cxK() {
        return this.gKj;
    }

    public JSONObject cxL() {
        return this.gKo;
    }

    public static c JS(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        return dT(jSONObject);
    }

    public static c dT(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.gKj = jSONObject.optJSONObject("extra");
        cVar.gKo = jSONObject.optJSONObject("src");
        try {
            JSONObject cxL = cVar.cxL();
            if (cxL != null) {
                cVar.roomId = cxL.optString("room_id");
                cVar.cover = cxL.optString("cover");
            }
            JSONObject cxK = cVar.cxK();
            if (cxK != null) {
                cVar.extra = cxK.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
