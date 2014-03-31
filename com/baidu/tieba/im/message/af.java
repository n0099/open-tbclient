package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public final class af extends com.baidu.adp.framework.message.a<Object> {
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;

    public af() {
        super(2001201);
    }

    public final void c(int i) {
        this.e = i;
    }

    public final void d(int i) {
        this.f = i;
    }

    public final String b() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String c() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final void d(String str) {
        this.d = str;
    }
}
