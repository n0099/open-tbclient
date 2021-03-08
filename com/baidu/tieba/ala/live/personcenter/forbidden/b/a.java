package com.baidu.tieba.ala.live.personcenter.forbidden.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private boolean hasMore;
    private int totalCount;
    private List<b> userList = new ArrayList();

    public void dJ(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("users");
            int optInt = jSONObject.optInt("has_more");
            this.totalCount = jSONObject.optInt("count");
            this.hasMore = optInt == 1;
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    b bVar = new b();
                    bVar.dJ(optJSONObject);
                    this.userList.add(bVar);
                }
            }
        }
    }

    public List<b> getUserList() {
        if (this.userList == null) {
            this.userList = new ArrayList();
        }
        return this.userList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public int getTotalCount() {
        return this.totalCount;
    }
}
