package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.bw;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.a.d {
    private com.baidu.tieba.im.message.al a = null;
    private bw b = null;
    private int c;
    private String d;
    private String e;

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    private com.baidu.tieba.im.message.al c() {
        com.baidu.tieba.im.message.al alVar = new com.baidu.tieba.im.message.al();
        alVar.a(this.d);
        alVar.b(this.e);
        alVar.a(this.c);
        return alVar;
    }

    public void a() {
        this.a = c();
        com.baidu.tieba.im.messageCenter.e.a().a(this.a);
    }

    public void b() {
        if (this.a != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.a);
            this.a = null;
        }
        if (this.b != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.b);
            this.b = null;
        }
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }
}
