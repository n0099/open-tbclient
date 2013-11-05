package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f1048a;
    private String b;
    private String c;

    public k(String str, String str2, String str3) {
        this.f1048a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ag agVar = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/s/clientcall");
        agVar.a("tid", this.f1048a);
        agVar.a("phonenum", this.b);
        agVar.a("optype", this.c);
        agVar.j();
    }
}
