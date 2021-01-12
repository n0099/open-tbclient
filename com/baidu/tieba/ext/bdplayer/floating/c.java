package com.baidu.tieba.ext.bdplayer.floating;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private JSONObject gRp;
    private JSONObject gRu;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject cwM() {
        return this.gRp;
    }

    public JSONObject cwN() {
        return this.gRu;
    }

    public static c IE(String str) {
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
        cVar.gRp = jSONObject.optJSONObject("extra");
        cVar.gRu = jSONObject.optJSONObject(UserAccountActionItem.KEY_SRC);
        try {
            JSONObject cwN = cVar.cwN();
            if (cwN != null) {
                cVar.roomId = cwN.optString("room_id");
                cVar.cover = cwN.optString("cover");
            }
            JSONObject cwM = cVar.cwM();
            if (cwM != null) {
                cVar.extra = cwM.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
