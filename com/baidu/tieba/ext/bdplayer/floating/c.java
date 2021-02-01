package com.baidu.tieba.ext.bdplayer.floating;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private JSONObject gTZ;
    private JSONObject gUe;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject getExtra() {
        return this.gTZ;
    }

    public JSONObject cxY() {
        return this.gUe;
    }

    public static c Jp(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        return ei(jSONObject);
    }

    public static c ei(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.gTZ = jSONObject.optJSONObject("extra");
        cVar.gUe = jSONObject.optJSONObject(UserAccountActionItem.KEY_SRC);
        try {
            JSONObject cxY = cVar.cxY();
            if (cxY != null) {
                cVar.roomId = cxY.optString("room_id");
                cVar.cover = cxY.optString("cover");
            }
            JSONObject extra = cVar.getExtra();
            if (extra != null) {
                cVar.extra = extra.toString();
                return cVar;
            }
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return cVar;
        }
    }
}
