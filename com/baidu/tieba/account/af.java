package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class af extends Thread {
    private String a;
    private String b;

    public af(String str) {
        this.a = null;
        this.b = null;
        this.a = str;
    }

    public af(String str, String str2) {
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.d.t tVar = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/pv");
        tVar.a("st_type", this.a);
        if (this.b != null) {
            tVar.a("st_param", this.b);
        }
        tVar.i();
    }
}
