package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.zeus.Headers;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class an {
    private int i;
    private ForumData a = new ForumData();
    private az b = new az();
    private ArrayList<ar> c = new ArrayList<>();
    private am d = new am();
    private AntiData e = new AntiData();
    private ah f = new ah();
    private int h = 0;
    private boolean g = false;
    private UserData j = new UserData();

    public an() {
        this.i = 0;
        this.i = 0;
    }

    public boolean a() {
        return this.c != null && this.c.size() > 0;
    }

    public String[] b() {
        String str = null;
        String str2 = "";
        if (a()) {
            ar arVar = this.c.get(0);
            LinkedList<String> imageUrl = arVar.getImageUrl();
            if (imageUrl != null && imageUrl.size() > 0) {
                str = imageUrl.get(0);
            }
            str2 = arVar.k();
        }
        return new String[]{str, str2};
    }

    public ForumData c() {
        return this.a;
    }

    public az d() {
        return this.b;
    }

    public ArrayList<ar> e() {
        return this.c;
    }

    public am f() {
        return this.d;
    }

    public void a(am amVar, int i) {
        this.d.c(amVar.d());
        this.d.b(amVar.b());
        this.d.a(amVar.a());
        this.d.d(amVar.e());
        if (i == 0) {
            this.d = amVar;
        } else if (i == 1) {
            this.d.e(amVar.f());
        } else if (i == 2) {
            this.d.f(amVar.g());
        }
    }

    public AntiData g() {
        return this.e;
    }

    public UserData h() {
        return this.j;
    }

    public boolean i() {
        return this.b.n() != 0;
    }

    public void a(boolean z) {
        if (this.b != null) {
            if (z) {
                this.b.c(1);
            } else {
                this.b.c(0);
            }
        }
    }

    public String j() {
        if (this.b != null) {
            return this.b.o();
        }
        return null;
    }

    public void a(String str) {
        if (this.b != null) {
            this.b.d(str);
        }
    }

    public void a(String str, Context context) {
        try {
            a(new JSONObject(str), context);
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        a(jSONObject, (Context) null);
    }

    public void a(JSONObject jSONObject, Context context) {
        if (jSONObject != null) {
            try {
                a(jSONObject.optInt("is_new_url", 0));
                this.a.parserJson(jSONObject.optJSONObject("forum"));
                this.b.a(jSONObject.optJSONObject("thread"));
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ar arVar = new ar();
                        arVar.a(optJSONArray.optJSONObject(i), context);
                        this.c.add(arVar);
                    }
                }
                this.d.a(jSONObject.optJSONObject("page"));
                this.e.parserJson(jSONObject.optJSONObject("anti"));
                this.f.a(jSONObject.optJSONObject(Headers.LOCATION));
                this.g = jSONObject.optInt("has_floor") == 1;
                this.h = jSONObject.optJSONObject("user").optInt("is_manager", 0);
                this.j.parserJson(jSONObject.optJSONObject("user"));
            } catch (Exception e) {
                com.baidu.tieba.util.be.b("PbData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public boolean k() {
        return this.g;
    }

    public int l() {
        return this.h;
    }

    public int m() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }
}
