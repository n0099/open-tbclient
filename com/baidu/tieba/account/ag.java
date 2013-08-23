package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ag extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f874a;
    private String b;

    public ag(String str) {
        this.f874a = null;
        this.b = null;
        this.f874a = str;
    }

    public ag(String str, String str2) {
        this.f874a = null;
        this.b = null;
        this.f874a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.v vVar = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/pv");
        vVar.a("st_type", this.f874a);
        if (this.b != null) {
            vVar.a("st_param", this.b);
        }
        vVar.j();
    }
}
