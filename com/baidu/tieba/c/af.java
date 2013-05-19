package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private ArrayList c;
    private int d = 0;
    private com.baidu.tieba.a.bd a = new com.baidu.tieba.a.bd();
    private com.baidu.tieba.a.b b = new com.baidu.tieba.a.b();

    public af() {
        this.c = null;
        this.c = new ArrayList();
        a(0);
    }

    public com.baidu.tieba.a.bd a() {
        return this.a;
    }

    public com.baidu.tieba.a.b b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("LoginModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a.a(jSONObject.optJSONObject("user"));
            this.b.a(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.c.add(optJSONArray.optString(i, null));
                }
            }
            a(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("LoginModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public ArrayList c() {
        return this.c;
    }

    public void a(int i) {
        this.d = i;
    }

    public int d() {
        return this.d;
    }
}
