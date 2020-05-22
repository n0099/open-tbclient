package com.baidu.tieba.ala.live.personcenter.admin.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private int maxCount;
    private List<b> userList = new ArrayList();

    public void cM(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("admins");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    b bVar = new b();
                    bVar.cM(optJSONObject);
                    this.userList.add(bVar);
                }
            }
            this.maxCount = jSONObject.optInt("total", 30);
        }
    }

    public int bvJ() {
        return this.maxCount;
    }

    public List<b> getUserList() {
        return this.userList;
    }
}
