package com.baidu.tieba.a;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList a = new ArrayList();

    public void a(JSONObject jSONObject, HashMap hashMap) {
        String str;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("uname");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < optJSONArray.length()) {
                    ai aiVar = new ai();
                    aiVar.b(optJSONArray.optString(i2));
                    if (hashMap != null && (str = (String) hashMap.get(aiVar.c())) != null) {
                        aiVar.c(str);
                    }
                    this.a.add(aiVar);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(String str, HashMap hashMap) {
        try {
            a(new JSONObject(str), hashMap);
        } catch (Exception e) {
            com.baidu.tieba.c.af.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(HashMap hashMap) {
        if (hashMap != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.a.size()) {
                    ai aiVar = (ai) this.a.get(i2);
                    aiVar.c((String) hashMap.get(aiVar.c()));
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
