package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class j extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f918a;
    private String b;
    private String c;

    public j(String str, String str2, String str3) {
        this.f918a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.z zVar = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/clientcall");
        zVar.a("tid", this.f918a);
        zVar.a("phonenum", this.b);
        zVar.a("optype", this.c);
        zVar.j();
    }
}
