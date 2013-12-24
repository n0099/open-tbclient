package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private String g;
    private String h;
    private int a = 0;
    private String b = "";
    private String c = "";
    private int d = 0;
    private int e = 0;
    private boolean f = false;
    private ArrayList<w> i = new ArrayList<>();

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("ForumFeedData", "parserJson", "error = " + e.getMessage());
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
                        w wVar = new w();
                        wVar.a(optJSONArray.optJSONObject(i));
                        this.i.add(wVar);
                    }
                    a(optJSONArray.length() == 0);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.be.b("ForumFeedData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(v vVar, boolean z) {
        if (vVar != null) {
            b(vVar.c());
            b(vVar.e());
            c(vVar.f());
            a(vVar.b() == null || vVar.b().size() == 0);
            if (z) {
                this.i.addAll(vVar.b());
            } else {
                this.i = vVar.b();
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

    public ArrayList<w> b() {
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
