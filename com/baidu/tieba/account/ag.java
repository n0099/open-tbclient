package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ag extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f1019a;
    private int b;
    private String c = null;

    public ag(int i, int i2) {
        this.f1019a = 0;
        this.b = 0;
        this.f1019a = i;
        this.b = i2;
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ag agVar = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/s/pv");
        agVar.a("img_num", String.valueOf(this.f1019a));
        agVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            agVar.a("img_type", this.c);
        }
        agVar.j();
    }
}
