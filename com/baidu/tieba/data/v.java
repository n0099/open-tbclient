package com.baidu.tieba.data;

import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private String l;
    private int m;
    private String s;
    private String t;
    private String u;
    private int v;
    private int w;
    private int x;
    private int y;

    /* renamed from: a  reason: collision with root package name */
    private String f1029a = null;
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
    private bb n = new bb();
    private ArrayList o = new ArrayList();
    private ArrayList p = new ArrayList();
    private String r = null;

    public v() {
        c((String) null);
        b((String) null);
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
    }

    public String a() {
        return this.f1029a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.h;
    }

    public int d() {
        return this.i;
    }

    public void a(int i) {
        this.j = i;
    }

    public int e() {
        return this.j;
    }

    public int f() {
        return this.x;
    }

    public int g() {
        return this.y;
    }

    public void b(int i) {
        this.k = i;
    }

    public int h() {
        return this.k;
    }

    public bb i() {
        return this.n;
    }

    public void a(bb bbVar) {
        this.n = bbVar;
    }

    public ArrayList j() {
        return this.p;
    }

    public String k() {
        return this.l;
    }

    public void a(String str) {
        this.l = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1029a = jSONObject.optString(LocaleUtil.INDONESIAN);
                this.b = jSONObject.optString("name");
                this.x = jSONObject.optInt("is_support_local", 0);
                this.y = jSONObject.optInt("is_local_effect", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("tag_info");
                if (optJSONObject != null) {
                    this.r = optJSONObject.optString("tag_name", null);
                    this.t = optJSONObject.optString("tag_id", null);
                    this.s = optJSONObject.optString("color", null);
                }
                this.u = jSONObject.optString("avatar", null);
                this.v = jSONObject.optInt("cur_score", 0);
                this.w = jSONObject.optInt("levelup_score", 0);
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
                c(jSONObject.optInt("favo_type", 0));
                JSONArray optJSONArray = jSONObject.optJSONArray("managers");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.o.add(((JSONObject) optJSONArray.opt(i)).optString("name"));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("good_classify");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        aa aaVar = new aa();
                        aaVar.a(optJSONArray2.optJSONObject(i2));
                        this.p.add(aaVar);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("sign_in_info");
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                    if (optJSONObject3 != null) {
                        this.n.b(optJSONObject3.optInt("is_sign_in"));
                        this.n.c(optJSONObject3.optInt("user_sign_rank"));
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("forum_info");
                    if (optJSONObject4 != null) {
                        if (optJSONObject4.optInt("is_on") == 0) {
                            this.n.a(-2);
                            return;
                        }
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("current_rank_info");
                        if (optJSONObject5 != null) {
                            this.n.a(optJSONObject5.optInt("sign_rank"));
                            this.n.d(optJSONObject5.optInt("sign_count"));
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b("ForumData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void c(int i) {
        this.m = i;
    }

    public int l() {
        return this.m;
    }

    public String m() {
        return this.r;
    }

    public String n() {
        return this.u;
    }

    public void b(String str) {
        this.s = str;
    }

    public String o() {
        return this.s;
    }

    public void c(String str) {
        this.t = str;
    }

    public void d(int i) {
        this.v = i;
    }

    public int p() {
        return this.v;
    }

    public void e(int i) {
        this.w = i;
    }

    public int q() {
        return this.w;
    }
}
