package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g {
    private ForumData a;
    private ArrayList<com.baidu.tbadk.core.data.o> b;
    private AntiData c;
    private com.baidu.tbadk.core.data.l d;
    private com.baidu.tieba.data.s e;
    private boolean f;
    private UserData g;
    private com.baidu.tieba.data.b h;
    private int i = 0;
    private cx j = null;
    private cw k = null;
    private boolean l = false;
    private k m = null;
    private h n = null;
    private boolean o = false;
    private long p = 0;
    private long q = 0;
    private long r = 0;
    private long s = 0;

    public final long a() {
        return this.s;
    }

    public final long b() {
        return this.q;
    }

    public final long c() {
        return this.r;
    }

    public final long d() {
        return this.p;
    }

    public final boolean e() {
        return this.f;
    }

    public g() {
        p();
    }

    private void p() {
        this.a = new ForumData();
        this.b = new ArrayList<>();
        this.d = new com.baidu.tbadk.core.data.l();
        this.e = new com.baidu.tieba.data.s();
        this.g = new UserData();
        this.c = new AntiData();
        this.h = new com.baidu.tieba.data.b();
    }

    public final void a(com.baidu.tieba.data.z zVar) {
        this.a.setCurScore(zVar.e());
        this.a.setLevelupScore(zVar.f());
        this.a.setLike(zVar.c());
        this.a.setUser_level(zVar.b());
        this.a.setLevelName(zVar.d());
    }

    public final void a(SignData signData) {
        this.a.setSignData(signData);
    }

    public final ForumData f() {
        return this.a;
    }

    public final ArrayList<com.baidu.tbadk.core.data.o> g() {
        return this.b;
    }

    public final UserData h() {
        return this.g;
    }

    public final AntiData i() {
        return this.c;
    }

    public final com.baidu.tbadk.core.data.l j() {
        return this.d;
    }

    public final com.baidu.tieba.data.s k() {
        return this.e;
    }

    public final void a(boolean z) {
        this.l = z;
    }

    public final boolean l() {
        return this.l;
    }

    public final void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            this.i = jSONObject.optInt("is_new_url", 0);
            this.f = jSONObject.optInt("fortune_bag", 0) == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("forum");
            p();
            this.a.parserJson(optJSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                    oVar.a(optJSONArray.optJSONObject(i));
                    oVar.E();
                    this.b.add(oVar);
                }
            }
            this.c.parserJson(jSONObject.optJSONObject("anti"));
            this.h.a(jSONObject.optJSONObject("group"));
            this.d.a(jSONObject.optJSONObject("page"));
            this.e.a(jSONObject.optJSONObject("frs_star"));
            this.e.j().a(optJSONObject.optJSONObject("superboy"));
            this.g.parserJson(jSONObject.optJSONObject("user"));
        } catch (Exception e) {
        }
    }

    public final void a(String str, ArrayList<BasicNameValuePair> arrayList, int i, boolean z, String str2) {
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        this.o = z;
        this.m = new k(this, str, arrayList, i, str2);
        this.m.setPriority(3);
        this.m.execute(str, arrayList);
    }

    public final void b(String str) {
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
        ForumData forumData = this.a;
        this.n = new h(this, forumData.getId(), forumData.getName(), str);
        this.n.setPriority(2);
        this.n.execute(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/user/fansno");
    }

    public final void m() {
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
    }

    public final void a(i iVar) {
        com.baidu.tieba.data.z zVar = new com.baidu.tieba.data.z();
        zVar.b(1);
        zVar.a(iVar.d);
        zVar.c(iVar.e);
        zVar.c(iVar.f);
        zVar.d(iVar.g);
        a(zVar);
    }

    public final void a(cx cxVar) {
        this.j = cxVar;
    }

    public final void a(cw cwVar) {
        this.k = cwVar;
    }

    public final int n() {
        return this.i;
    }

    public final com.baidu.tieba.data.b o() {
        return this.h;
    }
}
