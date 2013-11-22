package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f1086a;
    private String b;
    private String c;

    public l(String str, String str2, String str3) {
        this.f1086a = null;
        this.b = null;
        this.c = null;
        this.f1086a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ap apVar = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/s/pv");
        apVar.a("obj", this.f1086a);
        apVar.a("obj_tp", this.b);
        apVar.a("group_id", this.c);
        apVar.l();
    }
}
