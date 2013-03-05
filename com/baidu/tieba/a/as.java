package com.baidu.tieba.a;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class as {
    private ArrayList a = new ArrayList();

    public void a(JSONObject jSONObject, HashMap hashMap) {
        String str;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("uname");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < optJSONArray.length()) {
                    af afVar = new af();
                    afVar.c(optJSONArray.optString(i2));
                    if (hashMap != null && (str = (String) hashMap.get(afVar.c())) != null) {
                        afVar.d(str);
                    }
                    this.a.add(afVar);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(String str, HashMap hashMap) {
        try {
            a(new JSONObject(str), hashMap);
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(HashMap hashMap) {
        if (hashMap != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.a.size()) {
                    af afVar = (af) this.a.get(i2);
                    afVar.d((String) hashMap.get(afVar.c()));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public ArrayList a() {
        return this.a;
    }
}
