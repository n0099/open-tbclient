package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1003a = new ArrayList();

    public void a(JSONObject jSONObject, HashMap hashMap) {
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
                    if (hashMap != null && (str = (String) hashMap.get(metaData.getName())) != null) {
                        metaData.setPortrait(str);
                    }
                    this.f1003a.add(metaData);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(String str, HashMap hashMap) {
        try {
            a(new JSONObject(str), hashMap);
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b("AtListModel", "parserSuggestJson", "error = " + e.getMessage());
        }
    }

    public void a(HashMap hashMap) {
        if (hashMap != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f1003a.size()) {
                    MetaData metaData = (MetaData) this.f1003a.get(i2);
                    metaData.setPortrait((String) hashMap.get(metaData.getName()));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public ArrayList a() {
        return this.f1003a;
    }
}
