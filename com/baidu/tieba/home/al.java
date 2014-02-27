package com.baidu.tieba.home;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class al extends com.baidu.adp.a.d {
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

    public final void a(am amVar) {
        this.d = amVar;
    }

    public final void a(u uVar) {
        this.e = uVar;
    }

    public final u b() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public final boolean LoadData() {
        if (this.b != null) {
            return false;
        }
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
        String sb2 = sb.toString();
        this.b = new an(this);
        this.b.execute(sb2);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return true;
        }
        return false;
    }
}
