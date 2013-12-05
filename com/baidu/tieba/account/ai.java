package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ai extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f1045a;
    private String b;
    private boolean c;

    public ai(String str) {
        this.f1045a = null;
        this.b = null;
        this.c = false;
        this.f1045a = str;
        this.c = false;
    }

    public ai(String str, String str2) {
        this.f1045a = null;
        this.b = null;
        this.c = false;
        this.f1045a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.c) {
            str = "c/s/inpv";
        } else {
            str = "c/s/pv";
        }
        com.baidu.tieba.util.am amVar = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + str);
        amVar.a("st_type", this.f1045a);
        if (this.b != null) {
            amVar.a("st_param", this.b);
        }
        amVar.l();
    }
}
