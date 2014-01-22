package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.bd;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.a.d {
    private com.baidu.tieba.im.message.ah a;
    private bd b;
    private com.baidu.tieba.im.message.ac c;
    private int d = 2;

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.a);
        }
        if (this.b != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.b);
        }
        if (this.c != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.c);
            return false;
        }
        return false;
    }

    public void a() {
        this.a = new com.baidu.tieba.im.message.ah();
        this.a.a(10);
        com.baidu.tieba.im.messageCenter.e.a().a(this.a);
    }

    public void a(long j) {
        this.b = new bd();
        this.b.b(1);
        this.b.a(10);
        this.b.a(String.valueOf(j));
        com.baidu.tieba.im.messageCenter.e.a().a(this.b);
    }

    public void a(int i) {
        this.c = new com.baidu.tieba.im.message.ac();
        this.c.a(i);
        com.baidu.tieba.im.messageCenter.e.a().a(this.c);
    }

    public void b(long j) {
        this.b = new bd();
        this.b.b(0);
        this.b.a(10);
        this.b.a(String.valueOf(j));
        com.baidu.tieba.im.messageCenter.e.a().a(this.b);
    }

    public int b() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }
}
