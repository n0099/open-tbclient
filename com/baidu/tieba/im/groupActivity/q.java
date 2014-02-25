package com.baidu.tieba.im.groupActivity;

import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.ai;
import com.baidu.tieba.im.message.am;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.a.d {
    private int a;
    private long b;
    private int c;
    private am d;
    private am e;
    private ai f;
    private GroupActivityData g;

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public int b() {
        return this.a;
    }

    public void b(int i) {
        this.a = i;
    }

    public long c() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    private am e(int i) {
        am amVar = new am();
        amVar.b(i);
        amVar.a(this.c);
        return amVar;
    }

    public void c(int i) {
        this.d = e(i);
        com.baidu.tieba.im.messageCenter.e.a().a(this.d);
    }

    public void d() {
        if (this.d != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.d);
        }
        if (this.e != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.e);
        }
        if (this.f != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.f);
        }
    }

    public void d(int i) {
        this.e = e(i);
        this.e.e(-127);
        com.baidu.tieba.im.messageCenter.e.a().a(this.e);
    }

    public com.baidu.tieba.im.message.s e() {
        return this.e;
    }

    public com.baidu.tieba.im.message.s f() {
        return this.d;
    }

    public com.baidu.tieba.im.message.s g() {
        return this.f;
    }

    public void a(long j, int i) {
        this.f = new ai();
        this.f.a(i);
        this.f.a(j);
        com.baidu.tieba.im.messageCenter.e.a().a(this.f);
    }

    public GroupActivityData h() {
        return this.g;
    }

    public void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.g = groupActivityData;
        }
    }
}
