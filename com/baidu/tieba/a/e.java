package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private av a;
    private ArrayList b;

    public e() {
        this.a = null;
        this.b = null;
        this.a = new av();
        this.b = new ArrayList(3);
    }

    public av a() {
        return this.a;
    }

    public ArrayList b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "parserJson", e.getMessage());
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
            com.baidu.tieba.c.ag.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }
}
