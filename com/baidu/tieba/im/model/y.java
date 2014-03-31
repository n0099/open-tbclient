package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import java.util.List;
/* loaded from: classes.dex */
public final class y extends com.baidu.adp.a.e {
    private long a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private List<Long> f;
    private boolean g;
    private com.baidu.tieba.im.message.ap h;

    public final void a(com.baidu.tieba.im.message.ap apVar) {
        this.h = apVar;
    }

    public final int a() {
        return this.b;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final boolean b() {
        return this.g;
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final List<Long> c() {
        return this.f;
    }

    public final void a(List<Long> list) {
        this.f = list;
    }

    public final void b(boolean z) {
        this.e = z;
    }

    public final int d() {
        return this.c;
    }

    public final void b(int i) {
        this.c = 0;
    }

    public final void c(int i) {
        this.c += i;
    }

    public final int e() {
        return this.d;
    }

    public final void d(int i) {
        this.d = i;
    }

    public final long f() {
        return this.a;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(Intent intent) {
        this.a = intent.getLongExtra("group_id", 0L);
    }

    public final void a(Bundle bundle) {
        this.a = bundle.getLong("group_id", 0L);
        this.c = bundle.getInt("start_position", 0);
        this.d = bundle.getInt("len_position", 0);
    }

    public final void a(long j, int i, int i2, int i3) {
        com.baidu.tieba.im.message.ap apVar = new com.baidu.tieba.im.message.ap();
        apVar.b(j);
        apVar.d(i);
        apVar.e(i2);
        apVar.f(i3);
        super.sendMessage(apVar);
    }

    public final void a(long j, String str) {
        com.baidu.tieba.im.message.aw awVar = new com.baidu.tieba.im.message.aw();
        awVar.b(j);
        awVar.a(str);
        super.sendMessage(awVar);
    }

    public final void b(Bundle bundle) {
        bundle.putLong("group_id", this.a);
        bundle.putInt("start_position", this.c);
        bundle.putInt("len_position", this.d);
    }
}
