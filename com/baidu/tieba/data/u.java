package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String g;
    private String h;
    private int a = 0;
    private String b = "";
    private String c = "";
    private int d = 0;
    private int e = 0;
    private boolean f = false;
    private ArrayList<v> i = new ArrayList<>();

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("ForumFeedData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                a(jSONObject.optInt("is_new_url", 0));
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    this.a = optJSONObject.optInt("errno", 0);
                    this.b = optJSONObject.optString("errmsg", "");
                    this.c = optJSONObject.optString("usermsg", "");
                }
                b(jSONObject.optString("total"));
                b(jSONObject.optInt("has_more"));
                JSONArray optJSONArray = jSONObject.optJSONArray("feed_thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        v vVar = new v();
                        vVar.a(optJSONArray.optJSONObject(i));
                        this.i.add(vVar);
                    }
                    a(optJSONArray.length() == 0);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("ForumFeedData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(u uVar, boolean z) {
        if (uVar != null) {
            b(uVar.c());
            b(uVar.e());
            c(uVar.f());
            a(uVar.b() == null || uVar.b().size() == 0);
            if (z) {
                this.i.addAll(uVar.b());
            } else {
                this.i = uVar.b();
            }
        }
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public ArrayList<v> b() {
        return this.i;
    }

    public void b(int i) {
        this.e = i;
    }

    public int c() {
        return this.e;
    }

    public boolean d() {
        return this.e > 0;
    }

    public void b(String str) {
        this.g = str;
    }

    public String e() {
        return this.g;
    }

    public void c(String str) {
        this.h = str;
    }

    public String f() {
        return this.h;
    }

    public int g() {
        return this.a;
    }

    public String h() {
        return this.c;
    }
}
