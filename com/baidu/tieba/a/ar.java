package com.baidu.tieba.a;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private ArrayList a = new ArrayList();

    public ArrayList a() {
        return this.a;
    }

    public void a(String str, HashMap hashMap) {
        try {
            a(new JSONObject(str), hashMap);
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(HashMap hashMap) {
        if (hashMap == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                return;
            }
            ah ahVar = (ah) this.a.get(i2);
            ahVar.c((String) hashMap.get(ahVar.c()));
            i = i2 + 1;
        }
    }

    public void a(JSONObject jSONObject, HashMap hashMap) {
        String str;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("uname");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return;
                }
                ah ahVar = new ah();
                ahVar.b(optJSONArray.optString(i2));
                if (hashMap != null && (str = (String) hashMap.get(ahVar.c())) != null) {
                    ahVar.c(str);
                }
                this.a.add(ahVar);
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }
}
