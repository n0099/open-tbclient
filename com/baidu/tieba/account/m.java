package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f1097a;
    private String b;
    private String c;

    public m(String str, String str2, String str3) {
        this.f1097a = null;
        this.b = null;
        this.c = null;
        this.f1097a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.am amVar = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/s/pv");
        amVar.a("obj", this.f1097a);
        amVar.a("obj_tp", this.b);
        amVar.a("group_id", this.c);
        amVar.l();
    }
}
