package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class j extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f902a;
    private String b;
    private String c;

    public j(String str, String str2, String str3) {
        this.f902a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.v vVar = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/clientcall");
        vVar.a("tid", this.f902a);
        vVar.a("phonenum", this.b);
        vVar.a("optype", this.c);
        vVar.j();
    }
}
