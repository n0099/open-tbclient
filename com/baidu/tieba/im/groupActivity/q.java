package com.baidu.tieba.im.groupActivity;

import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.ai;
import com.baidu.tieba.im.message.am;
/* loaded from: classes.dex */
public final class q extends com.baidu.adp.a.d {
    private int a;
    private long b;
    private int c;
    private am d;
    private am e;
    private ai f;
    private GroupActivityData g;

    public final int a() {
        return this.c;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final int b() {
        return this.a;
    }

    public final void b(int i) {
        this.a = i;
    }

    public final long c() {
        return this.b;
    }

    public final void a(long j) {
        this.b = j;
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    private am e(int i) {
        am amVar = new am();
        amVar.b(i);
        amVar.a(this.c);
        return amVar;
    }

    public final void c(int i) {
        this.d = e(i);
        com.baidu.tieba.im.messageCenter.d.a().a(this.d);
    }

    public final void d() {
        if (this.d != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.d);
        }
        if (this.e != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.e);
        }
        if (this.f != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.f);
        }
    }

    public final void d(int i) {
        this.e = e(i);
        this.e.e(-127);
        com.baidu.tieba.im.messageCenter.d.a().a(this.e);
    }

    public final com.baidu.tieba.im.message.s e() {
        return this.e;
    }

    public final com.baidu.tieba.im.message.s f() {
        return this.d;
    }

    public final com.baidu.tieba.im.message.s g() {
        return this.f;
    }

    public final void a(long j, int i) {
        this.f = new ai();
        this.f.a(i);
        this.f.a(j);
        com.baidu.tieba.im.messageCenter.d.a().a(this.f);
    }

    public final GroupActivityData h() {
        return this.g;
    }

    public final void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.g = groupActivityData;
        }
    }
}
