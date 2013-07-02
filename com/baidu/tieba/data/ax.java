package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ax {
    private ArrayList a = new ArrayList();

    public void a(JSONObject jSONObject, HashMap hashMap) {
        String str;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("uname");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < optJSONArray.length()) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(optJSONArray.optString(i2));
                    if (hashMap != null && (str = (String) hashMap.get(metaData.getName_show())) != null) {
                        metaData.setPortrait(str);
                    }
                    this.a.add(metaData);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(String str, HashMap hashMap) {
        try {
            a(new JSONObject(str), hashMap);
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(HashMap hashMap) {
        if (hashMap != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.a.size()) {
                    MetaData metaData = (MetaData) this.a.get(i2);
                    metaData.setPortrait((String) hashMap.get(metaData.getName_show()));
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
