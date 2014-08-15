package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
public class di {
    private long a;
    private long b;
    private long c;

    public di(Context context) {
        a(0L);
        b(0L);
    }

    public void a(long j) {
        this.a = j;
    }

    public long a() {
        return this.a + this.b;
    }

    public void b(long j) {
        this.b = j;
    }

    public long b() {
        return this.c;
    }

    public void c(long j) {
        this.c = j;
    }
}
