package com.baidu.tieba.ext.bdplayer.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject gKh;
    private JSONObject gKm;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject cxJ() {
        return this.gKh;
    }

    public JSONObject cxK() {
        return this.gKm;
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
        cVar.gKh = jSONObject.optJSONObject("extra");
        cVar.gKm = jSONObject.optJSONObject("src");
        try {
            JSONObject cxK = cVar.cxK();
            if (cxK != null) {
                cVar.roomId = cxK.optString("room_id");
                cVar.cover = cxK.optString("cover");
            }
            JSONObject cxJ = cVar.cxJ();
            if (cxJ != null) {
                cVar.extra = cxJ.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
