package com.baidu.tieba.ala.floating;

import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private JSONObject gRp;
    private JSONObject gRu;

    public void dJ(JSONObject jSONObject) {
        this.gRp = jSONObject;
    }

    public void dK(JSONObject jSONObject) {
        this.gRu = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.gRp);
            jSONObject.put(UserAccountActionItem.KEY_SRC, this.gRu);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
