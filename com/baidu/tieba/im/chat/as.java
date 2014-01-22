package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.a.d {
    private String a;
    private String b;
    private int c;
    private com.baidu.tieba.im.message.at d;
    private com.baidu.tieba.im.message.ae e;

    public void a(String str, String str2, int i) {
        b(str);
        a(str2);
        b(i);
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b() {
        if (this.d != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.d);
            this.d = null;
        }
    }

    public void a(boolean z) {
        new at(this, z).execute(new Void[0]);
    }

    public void a(com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new au(this), aVar);
    }

    public void a(long j) {
        this.d = new com.baidu.tieba.im.message.at();
        this.d.a(j);
        this.d.a(TiebaApplication.E().getID());
        com.baidu.tieba.im.messageCenter.e.a().a(this.d);
    }

    public void a(int i) {
        this.e = new com.baidu.tieba.im.message.ae();
        this.e.a(i);
        com.baidu.tieba.im.messageCenter.e.a().a(this.e);
    }

    public String c() {
        return this.a;
    }

    public int d() {
        return com.baidu.adp.lib.f.b.a(this.a, 0);
    }

    public void b(String str) {
        this.a = str;
    }

    public int e() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }
}
