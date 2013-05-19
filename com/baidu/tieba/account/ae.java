package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ae extends Thread {
    private int a;
    private int b;
    private String c = null;

    public ae(int i, int i2) {
        this.a = 0;
        this.b = 0;
        this.a = i;
        this.b = i2;
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.d.t tVar = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/pv");
        tVar.a("img_num", String.valueOf(this.a));
        tVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            tVar.a("img_type", this.c);
        }
        tVar.i();
    }
}
