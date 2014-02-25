package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class x extends Thread {
    private String a;
    private String b;
    private String c;

    public x(String str, String str2, String str3) {
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
        com.baidu.tieba.util.ba baVar = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/pv");
        baVar.a("obj", this.a);
        baVar.a("obj_tp", this.b);
        baVar.a("group_id", this.c);
        baVar.m();
    }
}
