package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ag extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f1031a;
    private String b;

    public ag(String str) {
        this.f1031a = null;
        this.b = null;
        this.f1031a = str;
    }

    public ag(String str, String str2) {
        this.f1031a = null;
        this.b = null;
        this.f1031a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ap apVar = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/s/pv");
        apVar.a("st_type", this.f1031a);
        if (this.b != null) {
            apVar.a("st_param", this.b);
        }
        apVar.j();
    }
}
