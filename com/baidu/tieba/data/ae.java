package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ae {
    private int i;
    private ForumData a = new ForumData();
    private com.baidu.tbadk.core.data.o b = new com.baidu.tbadk.core.data.o();
    private ArrayList<ai> c = new ArrayList<>();
    private com.baidu.tbadk.core.data.l d = new com.baidu.tbadk.core.data.l();
    private AntiData e = new AntiData();
    private aa f = new aa();
    private int h = 0;
    private boolean g = false;
    private final UserData j = new UserData();
    private AdditionData k = new AdditionData();

    public ae() {
        this.i = 0;
        this.i = 0;
    }

    public final boolean a() {
        return this.c != null && this.c.size() > 0;
    }

    public final String[] b() {
        String str = null;
        String str2 = "";
        if (a()) {
            ai aiVar = this.c.get(0);
            LinkedList<String> imageUrl = aiVar.getImageUrl();
            if (imageUrl != null && imageUrl.size() > 0) {
                str = imageUrl.get(0);
            }
            str2 = aiVar.m();
        }
        return new String[]{str, str2};
    }

    public final ForumData c() {
        return this.a;
    }

    public final com.baidu.tbadk.core.data.o d() {
        return this.b;
    }

    public final ArrayList<ai> e() {
        return this.c;
    }

    public final com.baidu.tbadk.core.data.l f() {
        return this.d;
    }

    public final void a(com.baidu.tbadk.core.data.l lVar, int i) {
        this.d.c(lVar.d());
        this.d.b(lVar.b());
        this.d.a(lVar.a());
        this.d.d(lVar.e());
        if (i == 0) {
            this.d = lVar;
        } else if (i == 1) {
            this.d.e(lVar.f());
        } else if (i == 2) {
            this.d.f(lVar.g());
        }
    }

    public final AntiData g() {
        return this.e;
    }

    public final UserData h() {
        return this.j;
    }

    public final boolean i() {
        return this.b.x() != 0;
    }

    public final void a(boolean z) {
        if (this.b != null) {
            if (z) {
                this.b.e(1);
            } else {
                this.b.e(0);
            }
        }
    }

    public final String j() {
        if (this.b != null) {
            return this.b.y();
        }
        return null;
    }

    public final void a(String str) {
        if (this.b != null) {
            this.b.d(str);
        }
    }

    public final void a(String str, Context context) {
        try {
            a(new JSONObject(str), context);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public final void b(String str) {
        try {
            a(new JSONObject(str), (Context) null);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    private void a(JSONObject jSONObject, Context context) {
        if (jSONObject != null) {
            try {
                this.i = jSONObject.optInt("is_new_url", 0);
                this.a.parserJson(jSONObject.optJSONObject("forum"));
                this.b.a(jSONObject.optJSONObject("thread"));
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ai aiVar = new ai();
                        aiVar.a(optJSONArray.optJSONObject(i), context);
                        this.c.add(aiVar);
                    }
                }
                this.d.a(jSONObject.optJSONObject("page"));
                this.e.parserJson(jSONObject.optJSONObject("anti"));
                this.f.a(jSONObject.optJSONObject("location"));
                this.g = jSONObject.optInt("has_floor") == 1;
                this.h = jSONObject.optJSONObject("user").optInt("is_manager", 0);
                this.j.parserJson(jSONObject.optJSONObject("user"));
                this.k.parserJson(jSONObject.optJSONObject("add_post"));
                this.b.b(this.b.o() > 0 ? this.b.o() - 1 : 0);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("PbData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public final boolean k() {
        return this.g;
    }

    public final int l() {
        return this.h;
    }

    public final int m() {
        return this.i;
    }

    public final AdditionData n() {
        return this.k;
    }
}
