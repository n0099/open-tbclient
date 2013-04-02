package com.baidu.tieba.b;

import com.baidu.tieba.a.az;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private ArrayList c;
    private int d = 0;
    private az a = new az();
    private com.baidu.tieba.a.b b = new com.baidu.tieba.a.b();

    public h() {
        this.c = null;
        this.c = new ArrayList();
        a(0);
    }

    public az a() {
        return this.a;
    }

    public com.baidu.tieba.a.b b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            ag.b("LoginModel", "parserJson", "error = " + e.getMessage());
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
            ag.b("LoginModel", "parserJson", "error = " + e.getMessage());
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
