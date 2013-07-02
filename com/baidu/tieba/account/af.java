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
        com.baidu.tieba.util.r rVar = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/s/pv");
        rVar.a("st_type", this.a);
        if (this.b != null) {
            rVar.a("st_param", this.b);
        }
        rVar.j();
    }
}
