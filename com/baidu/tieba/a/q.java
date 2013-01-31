package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private String l;
    private int m;
    private String a = null;
    private String b = null;
    private String c = null;
    private String d = null;
    private int e = 0;
    private int f = 1;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int q = 0;
    private as n = new as();
    private ArrayList o = new ArrayList();
    private ArrayList p = new ArrayList();

    public int a() {
        return this.q;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.j;
    }

    public int e() {
        return this.k;
    }

    public as f() {
        return this.n;
    }

    public ArrayList g() {
        return this.p;
    }

    public String h() {
        return this.l;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.b = jSONObject.optString("name");
                this.c = jSONObject.optString("first_class");
                this.d = jSONObject.optString("second_class");
                this.e = jSONObject.optInt("is_exists", 0);
                this.f = jSONObject.optInt("is_forbidden", 1);
                this.g = jSONObject.optInt("thread_num", 0);
                this.h = jSONObject.optInt("post_num", 0);
                this.i = jSONObject.optInt("member_num", 0);
                this.j = jSONObject.optInt("is_like", 0);
                this.k = jSONObject.optInt("level_id", 0);
                this.l = jSONObject.optString("level_name", null);
                this.q = jSONObject.optInt("album_open_photo_frs", 0);
                a(jSONObject.optInt("favo_type", 0));
                JSONArray optJSONArray = jSONObject.optJSONArray("managers");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.o.add(((JSONObject) optJSONArray.opt(i)).optString("name"));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("good_classify");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        t tVar = new t();
                        tVar.a(optJSONArray2.optJSONObject(i2));
                        this.p.add(tVar);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("sign_in_info");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
                    if (optJSONObject2 != null) {
                        this.n.b(optJSONObject2.optInt("is_sign_in"));
                        this.n.c(optJSONObject2.optInt("user_sign_rank"));
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("forum_info");
                    if (optJSONObject3 != null) {
                        if (optJSONObject3.optInt("is_on") == 0) {
                            this.n.a(-2);
                            return;
                        }
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("current_rank_info");
                        if (optJSONObject4 != null) {
                            this.n.a(optJSONObject4.optInt("sign_rank"));
                            this.n.d(optJSONObject4.optInt("sign_count"));
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.c.af.b("ForumData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(int i) {
        this.m = i;
    }

    public int i() {
        return this.m;
    }
}
