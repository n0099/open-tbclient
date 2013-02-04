package com.baidu.tieba.b;

import com.baidu.tieba.a.au;
import com.baidu.tieba.c.ae;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private ArrayList c;
    private int d = 0;
    private au a = new au();
    private com.baidu.tieba.a.b b = new com.baidu.tieba.a.b();

    public g() {
        this.c = null;
        this.c = new ArrayList();
        a(0);
    }

    public au a() {
        return this.a;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            ae.b("LoginModel", "parserJson", "error = " + e.getMessage());
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
            ae.b("LoginModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public com.baidu.tieba.a.b b() {
        return this.b;
    }

    public ArrayList c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }
}
