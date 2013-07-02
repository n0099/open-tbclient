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
        com.baidu.tieba.util.r rVar = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/s/pv");
        rVar.a("img_num", String.valueOf(this.a));
        rVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            rVar.a("img_type", this.c);
        }
        rVar.j();
    }
}
