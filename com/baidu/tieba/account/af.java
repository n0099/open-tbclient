package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class af extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f889a;
    private int b;
    private String c = null;

    public af(int i, int i2) {
        this.f889a = 0;
        this.b = 0;
        this.f889a = i;
        this.b = i2;
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.z zVar = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/pv");
        zVar.a("img_num", String.valueOf(this.f889a));
        zVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            zVar.a("img_type", this.c);
        }
        zVar.j();
    }
}
