package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class af extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f873a;
    private int b;
    private String c = null;

    public af(int i, int i2) {
        this.f873a = 0;
        this.b = 0;
        this.f873a = i;
        this.b = i2;
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.v vVar = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/pv");
        vVar.a("img_num", String.valueOf(this.f873a));
        vVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            vVar.a("img_type", this.c);
        }
        vVar.j();
    }
}
