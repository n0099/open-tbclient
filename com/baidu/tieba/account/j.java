package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class j extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f881a;
    private String b;
    private String c;

    public j(String str, String str2, String str3) {
        this.f881a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.u uVar = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/clientcall");
        uVar.a("tid", this.f881a);
        uVar.a("phonenum", this.b);
        uVar.a("optype", this.c);
        uVar.k();
    }
}
