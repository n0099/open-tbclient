package com.baidu.tieba.home;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bk {
    private int a;
    private String b;
    private int c;
    private String d;
    private m e = new m();
    private ArrayList<bl> f = new ArrayList<>();

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public m c() {
        return this.e;
    }

    public ArrayList<bl> d() {
        return this.f;
    }

    public int e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    public void a(String str) {
        if (str != null) {
            try {
                a(new JSONObject(str));
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.e.a(jSONObject.optJSONObject("error"));
                this.a = jSONObject.optInt("show_dialog");
                this.b = jSONObject.optString("sign_notice");
                this.c = jSONObject.optInt("is_timeout");
                this.d = jSONObject.optString("timeout_notice");
                JSONArray optJSONArray = jSONObject.optJSONArray("info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        bl blVar = new bl();
                        blVar.a(jSONObject2);
                        this.f.add(blVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
