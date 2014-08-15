package com.baidu.tieba.d.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.gson.Gson;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class a {
    public final String a;
    public final String b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final int l;
    public final String m;
    public final int n;
    public final String o;
    public final String p;
    public final String q;
    public final int r;
    public final b[] s;
    public b t;

    public a() {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = 0;
        this.s = null;
        this.t = null;
    }

    public a(JSONObject jSONObject) {
        a aVar = (a) new Gson().fromJson(jSONObject.toString(), (Class<Object>) a.class);
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.k = aVar.k;
        this.r = aVar.r;
        this.s = aVar.s;
        if (this.s != null && this.s.length > 0) {
            this.t = this.s[0];
        } else {
            this.t = null;
        }
    }

    public a(App app) {
        if (app == null) {
            this.a = null;
            this.b = null;
            this.c = 0;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.l = 0;
            this.k = null;
            this.m = null;
            this.n = 0;
            this.o = null;
            this.p = null;
            this.q = null;
            this.r = 0;
            this.s = null;
            this.t = null;
            return;
        }
        this.a = app.id;
        this.b = app.name;
        this.c = app.url_type.intValue();
        this.d = app.url;
        this.f = app.apk_url;
        this.g = app.apk_name;
        this.e = app.ios_url;
        this.h = app.pos_name;
        this.i = app.first_name;
        this.j = app.second_name;
        this.l = app.cpid.intValue();
        this.k = app.price;
        this.m = app.abtest;
        this.n = app.plan_id.intValue();
        this.o = app.user_id;
        this.p = app.verify;
        this.q = app.ext_info;
        this.r = app.app_time.intValue();
        this.s = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.t = new b(goodsInfo);
                    return;
                }
            }
        }
    }

    public boolean a() {
        if (this.c == 2) {
            return false;
        }
        return b() || c();
    }

    public boolean b() {
        return (this.c != 3 || StringUtils.isNull(this.g) || StringUtils.isNull(this.f)) ? false : true;
    }

    public boolean c() {
        return this.c == 1 && !StringUtils.isNull(this.d);
    }
}
