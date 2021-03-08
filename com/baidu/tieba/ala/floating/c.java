package com.baidu.tieba.ala.floating;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private JSONObject gVW;
    private JSONObject gWb;

    public void dM(JSONObject jSONObject) {
        this.gVW = jSONObject;
    }

    public void dN(JSONObject jSONObject) {
        this.gWb = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.gVW);
            jSONObject.put(UserAccountActionItem.KEY_SRC, this.gWb);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
