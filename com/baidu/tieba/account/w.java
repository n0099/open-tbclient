package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class w extends Thread {
    private String a;
    private String b;
    private String c;

    public w(String str, String str2, String str3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.an anVar = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/s/pv");
        anVar.a("obj", this.a);
        anVar.a("obj_tp", this.b);
        anVar.a("group_id", this.c);
        anVar.l();
    }
}
