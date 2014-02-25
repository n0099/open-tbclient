package com.baidu.tieba.home;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj {
    private int a;
    private String b;
    private int c;
    private String d;
    private q e = new q();
    private ArrayList<ak> f = new ArrayList<>();

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public q c() {
        return this.e;
    }

    public ArrayList<ak> d() {
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
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
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
                        ak akVar = new ak();
                        akVar.a(jSONObject2);
                        this.f.add(akVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
