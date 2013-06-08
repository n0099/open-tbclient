package com.baidu.tieba.a;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class az {
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
                    aiVar.c(optJSONArray.optString(i2));
                    if (hashMap != null && (str = (String) hashMap.get(aiVar.d())) != null) {
                        aiVar.d(str);
                    }
                    this.a.add(aiVar);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(String str, HashMap hashMap) {
        try {
            a(new JSONObject(str), hashMap);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(HashMap hashMap) {
        if (hashMap != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.a.size()) {
                    ai aiVar = (ai) this.a.get(i2);
                    aiVar.d((String) hashMap.get(aiVar.d()));
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
