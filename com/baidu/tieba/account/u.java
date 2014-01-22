package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class u extends Thread {
    private String a;
    private String b;
    private String c;

    public u(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ax axVar = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/s/clientcall");
        axVar.a("tid", this.a);
        axVar.a("phonenum", this.b);
        axVar.a("optype", this.c);
        axVar.m();
    }
}
