package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ay {
    private ArrayList<MetaData> a = new ArrayList<>();

    public void a(JSONObject jSONObject, HashMap<String, String> hashMap) {
        String str;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("uname");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < optJSONArray.length()) {
                    MetaData metaData = new MetaData();
                    String optString = optJSONArray.optString(i2);
                    metaData.setName(optString);
                    metaData.setName_show(optString);
                    if (hashMap != null && (str = hashMap.get(metaData.getName())) != null) {
                        metaData.setPortrait(str);
                    }
                    this.a.add(metaData);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(String str, HashMap<String, String> hashMap) {
        try {
            a(new JSONObject(str), hashMap);
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.a.size()) {
                    MetaData metaData = this.a.get(i2);
                    metaData.setPortrait(hashMap.get(metaData.getName()));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public ArrayList<MetaData> a() {
        return this.a;
    }
}
