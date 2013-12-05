package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f1096a;
    private String b;
    private String c;

    public k(String str, String str2, String str3) {
        this.f1096a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.am amVar = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/s/clientcall");
        amVar.a("tid", this.f1096a);
        amVar.a("phonenum", this.b);
        amVar.a("optype", this.c);
        amVar.l();
    }
}
