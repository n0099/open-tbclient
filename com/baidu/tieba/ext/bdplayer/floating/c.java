package com.baidu.tieba.ext.bdplayer.floating;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private JSONObject gVW;
    private JSONObject gWb;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject getExtra() {
        return this.gVW;
    }

    public JSONObject cyl() {
        return this.gWb;
    }

    public static c Jz(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        return ek(jSONObject);
    }

    public static c ek(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.gVW = jSONObject.optJSONObject("extra");
        cVar.gWb = jSONObject.optJSONObject(UserAccountActionItem.KEY_SRC);
        try {
            JSONObject cyl = cVar.cyl();
            if (cyl != null) {
                cVar.roomId = cyl.optString("room_id");
                cVar.cover = cyl.optString("cover");
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
