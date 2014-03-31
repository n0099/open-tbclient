package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class cy {
    private String i = null;
    private String j = null;
    private ci k = null;
    private ci l = null;
    private int m = com.baidu.adp.framework.f.a().b();
    private com.baidu.adp.framework.c.b n = new cz(this, 1006003);
    private com.baidu.adp.framework.c.b o = new da(this, 1006002);
    private ForumData a = new ForumData();
    private ArrayList<com.baidu.tieba.data.ar> b = new ArrayList<>();
    private ArrayList<String> c = new ArrayList<>();
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private AntiData g = new AntiData();
    private com.baidu.tieba.data.ac h = new com.baidu.tieba.data.ac();

    public cy() {
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b(1006002, String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/frs/photolist");
        bVar.a(ImageForumListResponsedMessage.class);
        a.a(bVar);
        a.a(this.o);
        com.baidu.tbadk.c.b bVar2 = new com.baidu.tbadk.c.b(1006003, String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/frs/photo");
        bVar2.a(ImageForumResponsedMessage.class);
        a.a(bVar2);
        a.a(this.n);
    }

    public final com.baidu.tieba.data.ac a() {
        return this.h;
    }

    public final ForumData b() {
        return this.a;
    }

    public final ArrayList<com.baidu.tieba.data.ar> c() {
        return this.b;
    }

    public final ArrayList<String> d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public final AntiData f() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(cy cyVar, HttpResponsedMessage httpResponsedMessage) {
        Object g = httpResponsedMessage.h().g();
        if (g != null) {
            return com.baidu.adp.lib.f.b.a(g.toString(), 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ db a(cy cyVar, HttpResponsedMessage httpResponsedMessage, int i, int i2) {
        db dbVar = new db(cyVar);
        dbVar.a = true;
        dbVar.b = i == 200;
        dbVar.c = i2;
        dbVar.d = httpResponsedMessage.f();
        dbVar.e = com.baidu.adp.lib.f.b.a(httpResponsedMessage.b(), 0L);
        return dbVar;
    }

    public final void a(int i, int i2, int i3) {
        if (com.baidu.adp.framework.c.a().a(1006002, this.m).size() <= 0) {
            HttpMessage httpMessage = new HttpMessage(1006002);
            if (this.i != null) {
                httpMessage.a("st_type", this.i);
            }
            httpMessage.b(Integer.valueOf(i));
            httpMessage.a("kw", this.j);
            httpMessage.a("bs", String.valueOf(i));
            httpMessage.a("be", String.valueOf((i + 240) - 1));
            httpMessage.a("an", String.valueOf(30));
            httpMessage.a("scr_w", String.valueOf(i2));
            httpMessage.a("scr_h", String.valueOf(i3));
            httpMessage.b(this.m);
            com.baidu.adp.framework.c.a().a(httpMessage);
        }
    }

    public final void a(int i) {
        if (com.baidu.adp.framework.c.a().a(1006003, this.m).size() <= 0) {
            if (i < 0) {
                i = 0;
            }
            HttpMessage httpMessage = new HttpMessage(1006003);
            httpMessage.b(Integer.valueOf(i));
            StringBuilder sb = new StringBuilder();
            int size = this.c.size();
            for (int i2 = i; i2 < size && i2 < i + 30; i2++) {
                sb.append(this.c.get(i2));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            httpMessage.a("alb_ids", sb.toString());
            httpMessage.a("kw", this.j);
            httpMessage.b(this.m);
            com.baidu.adp.framework.c.a().a(httpMessage);
        }
    }

    public final void g() {
        com.baidu.adp.framework.c.a().b(1006002, this.m);
        com.baidu.adp.framework.c.a().b(1006003, this.m);
    }

    public final void a(String str, String str2) {
        this.i = str;
        this.j = str2;
    }

    public final void a(ci ciVar) {
        this.k = ciVar;
    }

    public final void b(ci ciVar) {
        this.l = ciVar;
    }
}
