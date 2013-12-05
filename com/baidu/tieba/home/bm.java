package com.baidu.tieba.home;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.a.d {
    private static bm f = new bm();

    /* renamed from: a  reason: collision with root package name */
    public boolean f1477a;
    private bk c;
    private t e;
    private bo b = null;
    private bn d = null;

    public static bm a() {
        return f;
    }

    private bm() {
        this.c = null;
        this.c = new bk();
    }

    public void a(bn bnVar) {
        this.d = bnVar;
    }

    public void a(t tVar) {
        this.e = tVar;
    }

    public t b() {
        return this.e;
    }

    private String c() {
        ArrayList<u> m = this.e.m();
        int size = m.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            u uVar = m.get(i);
            if (uVar.j()) {
                if (!uVar.k()) {
                    uVar.c(true);
                }
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(uVar.a());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        if (this.b != null) {
            return false;
        }
        String c = c();
        this.b = new bo(this);
        this.b.execute(c);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return true;
        }
        return false;
    }
}
