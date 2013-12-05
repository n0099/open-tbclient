package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ah extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f1044a;
    private int b;
    private String c = null;

    public ah(int i, int i2) {
        this.f1044a = 0;
        this.b = 0;
        this.f1044a = i;
        this.b = i2;
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.am amVar = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/s/pv");
        amVar.a("img_num", String.valueOf(this.f1044a));
        amVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            amVar.a("img_type", this.c);
        }
        amVar.l();
    }
}
