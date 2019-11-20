package com.baidu.tieba.ala.live.personcenter.admin.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private List<b> userList = new ArrayList();

    public void bM(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("admins")) != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                b bVar = new b();
                bVar.bM(optJSONObject);
                this.userList.add(bVar);
            }
        }
    }

    public List<b> getUserList() {
        return this.userList;
    }
}
