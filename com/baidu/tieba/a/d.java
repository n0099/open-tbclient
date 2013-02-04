package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private au a;
    private ArrayList b;

    public d() {
        this.a = null;
        this.b = null;
        this.a = new au();
        this.b = new ArrayList(3);
    }

    public au a() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a.a(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.b.add(optJSONArray.optString(i, null));
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public ArrayList b() {
        return this.b;
    }
}
