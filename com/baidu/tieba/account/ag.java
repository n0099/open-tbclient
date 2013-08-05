package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ag extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f855a;
    private String b;

    public ag(String str) {
        this.f855a = null;
        this.b = null;
        this.f855a = str;
    }

    public ag(String str, String str2) {
        this.f855a = null;
        this.b = null;
        this.f855a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.u uVar = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/pv");
        uVar.a("st_type", this.f855a);
        if (this.b != null) {
            uVar.a("st_param", this.b);
        }
        uVar.k();
    }
}
