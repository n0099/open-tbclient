package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class af extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f854a;
    private int b;
    private String c = null;

    public af(int i, int i2) {
        this.f854a = 0;
        this.b = 0;
        this.f854a = i;
        this.b = i2;
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.u uVar = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/pv");
        uVar.a("img_num", String.valueOf(this.f854a));
        uVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            uVar.a("img_type", this.c);
        }
        uVar.k();
    }
}
