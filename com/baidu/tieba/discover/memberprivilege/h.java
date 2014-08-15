package com.baidu.tieba.discover.memberprivilege;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
class h {
    public k a = new k();
    public List<i> b = new ArrayList();

    public List<i> a() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a.a(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    i iVar = new i();
                    iVar.a(optJSONArray.getJSONObject(i));
                    this.b.add(iVar);
                }
            }
        }
    }
}
