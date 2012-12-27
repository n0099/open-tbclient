package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ak extends Thread {
    private String a;
    private String b;

    public ak(String str) {
        this.a = null;
        this.b = null;
        this.a = str;
    }

    public ak(String str, String str2) {
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.c.t tVar = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/pv");
        tVar.a("st_type", this.a);
        if (this.b != null) {
            tVar.a("st_param", this.b);
        }
        tVar.i();
    }
}
