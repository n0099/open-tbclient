package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a a;

    public NewsNotifyMessage() {
        super(2001124);
        this.a = new a(this);
    }

    public final int b() {
        int i;
        i = this.a.b;
        return i;
    }

    public final void b(int i) {
        this.a.b = i;
    }

    public final int c() {
        int i;
        i = this.a.c;
        return i;
    }

    public final void c(int i) {
        this.a.c = i;
    }

    public final int d() {
        int i;
        i = this.a.d;
        return i;
    }

    public final void d(int i) {
        this.a.d = i;
    }

    public final int i() {
        int i;
        i = this.a.e;
        return i;
    }

    public final void e(int i) {
        this.a.e = i;
    }

    public final int j() {
        int i;
        i = this.a.f;
        return i;
    }

    public final void f(int i) {
        this.a.f = i;
    }
}
