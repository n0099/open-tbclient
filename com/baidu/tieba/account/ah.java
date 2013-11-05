package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ah extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f1020a;
    private String b;

    public ah(String str) {
        this.f1020a = null;
        this.b = null;
        this.f1020a = str;
    }

    public ah(String str, String str2) {
        this.f1020a = null;
        this.b = null;
        this.f1020a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ag agVar = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/s/pv");
        agVar.a("st_type", this.f1020a);
        if (this.b != null) {
            agVar.a("st_param", this.b);
        }
        agVar.j();
    }
}
