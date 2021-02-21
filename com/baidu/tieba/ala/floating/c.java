package com.baidu.tieba.ala.floating;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private JSONObject gUn;
    private JSONObject gUs;

    public void dK(JSONObject jSONObject) {
        this.gUn = jSONObject;
    }

    public void dL(JSONObject jSONObject) {
        this.gUs = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.gUn);
            jSONObject.put(UserAccountActionItem.KEY_SRC, this.gUs);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
