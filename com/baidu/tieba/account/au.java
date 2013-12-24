package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class au extends Thread {
    private int a;
    private int b;
    private String c = null;

    public au(int i, int i2) {
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
        com.baidu.tieba.util.an anVar = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/s/pv");
        anVar.a("img_num", String.valueOf(this.a));
        anVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            anVar.a("img_type", this.c);
        }
        anVar.l();
    }
}
