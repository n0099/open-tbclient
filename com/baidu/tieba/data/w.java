package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private String f;
    private String g;

    /* renamed from: a  reason: collision with root package name */
    private int f1180a = 0;
    private String b = "";
    private String c = "";
    private int d = 0;
    private boolean e = false;
    private ArrayList<x> h = new ArrayList<>();

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
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    this.f1180a = optJSONObject.optInt("errno", 0);
                    this.b = optJSONObject.optString("errmsg", "");
                    this.c = optJSONObject.optString("usermsg", "");
                }
                b(jSONObject.optString("total"));
                a(jSONObject.optInt("has_more"));
                JSONArray optJSONArray = jSONObject.optJSONArray("feed_thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        x xVar = new x();
                        xVar.a(optJSONArray.optJSONObject(i));
                        this.h.add(xVar);
                    }
                    a(optJSONArray.length() == 0);
                }
            } catch (Exception e) {
                com.baidu.tieba.util.be.b("ForumFeedData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(w wVar, boolean z) {
        if (wVar != null) {
            a(wVar.b());
            b(wVar.d());
            c(wVar.e());
            a(wVar.a() == null || wVar.a().size() == 0);
            if (z) {
                this.h.addAll(wVar.a());
            } else {
                this.h = wVar.a();
            }
        }
    }

    public void a(boolean z) {
        this.e = z;
    }

    public ArrayList<x> a() {
        return this.h;
    }

    public void a(int i) {
        this.d = i;
    }

    public int b() {
        return this.d;
    }

    public boolean c() {
        return this.d > 0;
    }

    public void b(String str) {
        this.f = str;
    }

    public String d() {
        return this.f;
    }

    public void c(String str) {
        this.g = str;
    }

    public String e() {
        return this.g;
    }

    public int f() {
        return this.f1180a;
    }

    public String g() {
        return this.c;
    }
}
