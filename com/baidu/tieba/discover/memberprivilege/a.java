package com.baidu.tieba.discover.memberprivilege;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public f apf = new f();
    public List<d> apg = new ArrayList();

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.apf.parseJson(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    d dVar = new d();
                    dVar.parseJson(optJSONArray.getJSONObject(i));
                    this.apg.add(dVar);
                }
            }
        }
    }
}
