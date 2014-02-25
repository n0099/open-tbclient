package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class aw extends Thread {
    private int a;
    private int b;
    private String c = null;

    public aw(int i, int i2) {
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
        com.baidu.tieba.util.ba baVar = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/pv");
        baVar.a("img_num", String.valueOf(this.a));
        baVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            baVar.a("img_type", this.c);
        }
        baVar.m();
    }
}
