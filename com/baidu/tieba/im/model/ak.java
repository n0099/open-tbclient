package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.bt;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.a.d {
    private com.baidu.tieba.im.message.ai a = null;
    private bt b = null;
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

    private com.baidu.tieba.im.message.ai c() {
        com.baidu.tieba.im.message.ai aiVar = new com.baidu.tieba.im.message.ai();
        aiVar.a(this.d);
        aiVar.b(this.e);
        aiVar.a(this.c);
        return aiVar;
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
