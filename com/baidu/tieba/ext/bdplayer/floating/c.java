package com.baidu.tieba.ext.bdplayer.floating;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private JSONObject gUn;
    private JSONObject gUs;
    public String roomId = null;
    public String cover = null;
    public String extra = null;

    public JSONObject getExtra() {
        return this.gUn;
    }

    public JSONObject cyf() {
        return this.gUs;
    }

    public static c Jq(String str) {
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
        cVar.gUn = jSONObject.optJSONObject("extra");
        cVar.gUs = jSONObject.optJSONObject(UserAccountActionItem.KEY_SRC);
        try {
            JSONObject cyf = cVar.cyf();
            if (cyf != null) {
                cVar.roomId = cyf.optString("room_id");
                cVar.cover = cyf.optString("cover");
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
