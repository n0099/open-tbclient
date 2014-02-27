package com.baidu.tieba.account;
/* loaded from: classes.dex */
public final class v extends Thread {
    private String a;
    private String b;
    private String c;

    public v(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        com.baidu.tieba.util.ba baVar = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/clientcall");
        baVar.a("tid", this.a);
        baVar.a("phonenum", this.b);
        baVar.a("optype", this.c);
        baVar.l();
    }
}
