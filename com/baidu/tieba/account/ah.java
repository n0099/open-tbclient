package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ah extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f1034a;
    private String b;

    public ah(String str) {
        this.f1034a = null;
        this.b = null;
        this.f1034a = str;
    }

    public ah(String str, String str2) {
        this.f1034a = null;
        this.b = null;
        this.f1034a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ap apVar = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/s/pv");
        apVar.a("st_type", this.f1034a);
        if (this.b != null) {
            apVar.a("st_param", this.b);
        }
        apVar.l();
    }
}
