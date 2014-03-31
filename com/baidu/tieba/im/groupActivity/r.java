package com.baidu.tieba.im.groupActivity;

import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.ac;
import com.baidu.tieba.im.message.ah;
import com.baidu.tieba.im.message.ai;
/* loaded from: classes.dex */
public final class r extends com.baidu.adp.a.e {
    private int a;
    private long b;
    private int c;
    private ai d;
    private ah e;
    private ac f;
    private com.baidu.tbadk.a g;
    private GroupActivityData h;

    public r(com.baidu.tbadk.a aVar) {
        this.g = aVar;
    }

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

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void c(int i) {
        ai aiVar = new ai();
        aiVar.e(i);
        aiVar.d(this.c);
        this.d = aiVar;
        this.g.sendMessage(this.d);
    }

    @Override // com.baidu.adp.a.e
    public final void cancelMessage() {
    }

    public final void d(int i) {
        ah ahVar = new ah();
        ahVar.d(i);
        ahVar.c(this.c);
        this.e = ahVar;
        this.g.sendMessage(this.e);
    }

    public final com.baidu.adp.framework.message.d<?> d() {
        return this.e;
    }

    public final com.baidu.adp.framework.message.d<?> e() {
        return this.d;
    }

    public final com.baidu.adp.framework.message.d<?> f() {
        return this.f;
    }

    public final void a(long j, int i) {
        this.f = new ac();
        this.f.d(i);
        this.f.b(j);
        this.g.sendMessage(this.f);
    }

    public final GroupActivityData g() {
        return this.h;
    }

    public final void a(GroupActivityData groupActivityData) {
        if (groupActivityData != null) {
            this.h = groupActivityData;
        }
    }
}
