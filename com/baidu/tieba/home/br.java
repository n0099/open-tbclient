package com.baidu.tieba.home;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class br extends com.baidu.adp.a.d {
    private static br f = new br();

    /* renamed from: a  reason: collision with root package name */
    public boolean f1427a;
    private bp c;
    private y e;
    private bt b = null;
    private bs d = null;

    public static br a() {
        return f;
    }

    private br() {
        this.c = null;
        this.c = new bp();
    }

    public void a(bs bsVar) {
        this.d = bsVar;
    }

    public void a(y yVar) {
        this.e = yVar;
    }

    public y b() {
        return this.e;
    }

    private String c() {
        ArrayList<z> m = this.e.m();
        int size = m.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            z zVar = m.get(i);
            if (zVar.j()) {
                if (!zVar.k()) {
                    zVar.c(true);
                }
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(zVar.a());
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
        this.b = new bt(this);
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
