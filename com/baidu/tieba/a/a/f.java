package com.baidu.tieba.a.a;

import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static f b;
    private long c = 0;
    private final a a = new a();

    private f() {
    }

    public static f a() {
        if (b == null) {
            b = new f();
        }
        return b;
    }

    protected long b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= this.c) {
            this.c++;
            return this.c;
        }
        return currentTimeMillis;
    }

    public void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            dVar.a(b());
            this.a.a(dVar);
        }
    }

    public List a(String str, String str2) {
        return this.a.a(str, str2, 20);
    }

    public void b(String str, String str2) {
        this.a.a(str, str2);
    }

    public void a(String str, List list) {
        this.a.a(str, list);
    }

    public List a(String str) {
        return this.a.a(str, 20);
    }
}
