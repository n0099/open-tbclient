package com.baidu.tieba.data.a;

import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static f b;
    private long c = 0;

    /* renamed from: a  reason: collision with root package name */
    private final a f989a = new a();

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

    public void a(List<d> list) {
        for (d dVar : list) {
            dVar.a(b());
            this.f989a.a(dVar);
        }
    }

    public List<d> a(String str, String str2) {
        return this.f989a.a(str, str2, 20);
    }

    public void b(String str, String str2) {
        this.f989a.a(str, str2);
    }

    public void a(String str, List<g> list) {
        this.f989a.a(str, list);
    }

    public List<g> a(String str) {
        return this.f989a.a(str, 20);
    }
}
