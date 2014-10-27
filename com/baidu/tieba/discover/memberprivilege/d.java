package com.baidu.tieba.discover.memberprivilege;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
class d {
    public ArrayList<b> apl = new ArrayList<>();
    public String mClassName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mClassName = jSONObject.optString("class_name");
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    b bVar = new b();
                    bVar.parseJson(jSONObject2);
                    this.apl.add(bVar);
                }
            }
        }
    }
}
