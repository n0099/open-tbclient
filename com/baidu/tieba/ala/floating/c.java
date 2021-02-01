package com.baidu.tieba.ala.floating;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private JSONObject gTZ;
    private JSONObject gUe;

    public void dK(JSONObject jSONObject) {
        this.gTZ = jSONObject;
    }

    public void dL(JSONObject jSONObject) {
        this.gUe = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.gTZ);
            jSONObject.put(UserAccountActionItem.KEY_SRC, this.gUe);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
