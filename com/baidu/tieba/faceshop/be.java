package com.baidu.tieba.faceshop;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class be extends com.baidu.adp.a.d {
    private String d;
    private int f;
    private int g;
    private float h;
    private bg b = null;
    private FaceShopData a = null;
    private boolean e = false;
    private int c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(be beVar) {
        int i = beVar.c;
        beVar.c = i + 1;
        return i;
    }

    public be() {
        this.f = 0;
        this.g = 0;
        TiebaApplication g = TiebaApplication.g();
        this.f = com.baidu.adp.lib.h.g.b(g);
        this.g = com.baidu.adp.lib.h.g.c(g);
        this.h = g.getResources().getDisplayMetrics().density;
    }

    public FaceShopData a() {
        return this.a;
    }

    public boolean b() {
        return this.e;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(int i) {
        if (this.b == null) {
            this.b = new bg(this);
            this.b.setPriority(3);
            this.b.execute(Integer.valueOf(i));
        }
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return true;
        }
        return true;
    }
}
