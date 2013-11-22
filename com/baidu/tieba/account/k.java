package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f1085a;
    private String b;
    private String c;

    public k(String str, String str2, String str3) {
        this.f1085a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ap apVar = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/s/clientcall");
        apVar.a("tid", this.f1085a);
        apVar.a("phonenum", this.b);
        apVar.a("optype", this.c);
        apVar.l();
    }
}
