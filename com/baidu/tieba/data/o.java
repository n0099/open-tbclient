package com.baidu.tieba.data;

import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class o {
    private int k;
    private String l;
    private String m;
    private int n = 0;
    private int o = 0;
    private List<w> p = null;
    private int a = 0;
    private long b = 0;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private MetaData i = new MetaData();
    private MetaData j = new MetaData();

    public final String a() {
        return this.m;
    }

    public final int b() {
        return this.n;
    }

    public final List<w> c() {
        return this.p;
    }

    public final int d() {
        return this.a;
    }

    public final long e() {
        return this.b;
    }

    public final String f() {
        return this.c;
    }

    public final String g() {
        return this.d;
    }

    public final String h() {
        return this.e;
    }

    public final String i() {
        return this.f;
    }

    public final String j() {
        return this.g;
    }

    public final String k() {
        return this.h;
    }

    public final MetaData l() {
        return this.i;
    }

    public final boolean m() {
        return this.k == 1;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("type", 0);
                this.c = jSONObject.optString("title");
                this.b = jSONObject.optLong("time", 0L) * 1000;
                this.d = jSONObject.optString("fname");
                this.e = jSONObject.optString("content");
                this.f = jSONObject.optString("quote_content");
                this.g = jSONObject.optString("thread_id");
                this.h = jSONObject.optString("post_id");
                this.k = jSONObject.optInt("is_floor");
                this.l = jSONObject.optString("quote_pid");
                this.m = jSONObject.optString("item_type");
                if (!com.baidu.adp.lib.util.h.b(this.m) && this.m.equals("zan")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("zan");
                    this.n = optJSONObject.optInt("num");
                    this.o = optJSONObject.optInt("is_liked");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("liker_list");
                    if (optJSONArray != null) {
                        this.p = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            w wVar = new w();
                            wVar.a(optJSONArray.optJSONObject(i));
                            this.p.add(wVar);
                        }
                    }
                }
                this.i.parserJson(jSONObject.optJSONObject("replyer"));
                this.j.parserJson(jSONObject.optJSONObject("quote_user"));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FeedData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
