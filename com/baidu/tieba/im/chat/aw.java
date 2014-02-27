package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public final class aw extends com.baidu.adp.a.d {
    private String a;
    private String b;
    private int c;
    private com.baidu.tieba.im.message.az d;
    private com.baidu.tieba.im.message.aj e;

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b() {
        if (this.d != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.d);
            this.d = null;
        }
    }

    public final void a(boolean z) {
        new ax(this, z).execute(new Void[0]);
    }

    public final void a(long j) {
        this.d = new com.baidu.tieba.im.message.az();
        this.d.a(j);
        this.d.a(TiebaApplication.y().getID());
        com.baidu.tieba.im.messageCenter.d.a().a(this.d);
    }

    public final void a(int i) {
        this.e = new com.baidu.tieba.im.message.aj();
        this.e.a(i);
        com.baidu.tieba.im.messageCenter.d.a().a(this.e);
    }

    public final String c() {
        return this.a;
    }

    public final int d() {
        return com.baidu.adp.lib.f.b.a(this.a, 0);
    }

    public final void b(String str) {
        this.a = str;
    }

    public final int e() {
        return this.c;
    }

    public final void b(int i) {
        this.c = i;
    }
}
