package com.baidu.tieba.home;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class al extends com.baidu.adp.a.d {
    private static al f = new al();
    public boolean a;
    private aj c;
    private u e;
    private an b = null;
    private am d = null;

    public static al a() {
        return f;
    }

    private al() {
        this.c = null;
        this.c = new aj();
    }

    public void a(am amVar) {
        this.d = amVar;
    }

    public void a(u uVar) {
        this.e = uVar;
    }

    public u b() {
        return this.e;
    }

    private String c() {
        ArrayList<v> m = this.e.m();
        int size = m.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            v vVar = m.get(i);
            if (vVar.j()) {
                if (!vVar.k()) {
                    vVar.c(true);
                }
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(vVar.a());
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
        this.b = new an(this);
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
