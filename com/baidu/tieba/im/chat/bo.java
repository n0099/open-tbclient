package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class bo extends com.baidu.adp.a.e {
    private String a;
    private String b;
    private int c;
    private com.baidu.tieba.im.message.av d;
    private com.baidu.tieba.im.message.ad e;
    private com.baidu.tbadk.a f;

    public bo(com.baidu.tbadk.a aVar) {
        this.f = null;
        this.f = aVar;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.adp.a.e
    public final void cancelMessage() {
        if (this.d != null) {
            this.d = null;
        }
    }

    public final void a(boolean z) {
        new bp(this, z).execute(new Void[0]);
    }

    public final void a(long j) {
        this.d = new com.baidu.tieba.im.message.av();
        this.d.b(j);
        this.d.a(TbadkApplication.N().getID());
        if (this.f != null) {
            this.f.sendMessage(this.d);
        } else {
            sendMessage(this.d);
        }
    }

    public final void a(int i) {
        this.e = new com.baidu.tieba.im.message.ad();
        this.e.d(i);
        if (this.f != null) {
            this.f.sendMessage(this.e);
        } else {
            sendMessage(this.e);
        }
    }

    public final String b() {
        return this.a;
    }

    public final int c() {
        return com.baidu.adp.lib.f.b.a(this.a, 0);
    }

    public final void b(String str) {
        this.a = str;
    }

    public final int d() {
        return this.c;
    }

    public final void b(int i) {
        this.c = i;
    }
}
