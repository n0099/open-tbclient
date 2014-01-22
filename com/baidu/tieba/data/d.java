package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private UserData a;
    private ArrayList<String> b;

    public d() {
        this.a = null;
        this.b = null;
        this.a = new UserData();
        this.b = new ArrayList<>(3);
    }

    public UserData a() {
        return this.a;
    }

    public ArrayList<String> b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a.parserJson(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.b.add(optJSONArray.optString(i, null));
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }
}
