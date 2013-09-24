package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ag extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f890a;
    private String b;

    public ag(String str) {
        this.f890a = null;
        this.b = null;
        this.f890a = str;
    }

    public ag(String str, String str2) {
        this.f890a = null;
        this.b = null;
        this.f890a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.z zVar = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/pv");
        zVar.a("st_type", this.f890a);
        if (this.b != null) {
            zVar.a("st_param", this.b);
        }
        zVar.j();
    }
}
