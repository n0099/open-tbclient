package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class af extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f1030a;
    private int b;
    private String c = null;

    public af(int i, int i2) {
        this.f1030a = 0;
        this.b = 0;
        this.f1030a = i;
        this.b = i2;
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ap apVar = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/s/pv");
        apVar.a("img_num", String.valueOf(this.f1030a));
        apVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            apVar.a("img_type", this.c);
        }
        apVar.j();
    }
}
