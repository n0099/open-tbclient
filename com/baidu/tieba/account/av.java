package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class av extends Thread {
    private String a;
    private String b;
    private boolean c;

    public av(String str) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = str;
        this.c = false;
    }

    public av(String str, String str2) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        super.run();
        if (this.c) {
            str = "c/s/inpv";
        } else {
            str = "c/s/pv";
        }
        com.baidu.tieba.util.an anVar = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + str);
        anVar.a("st_type", this.a);
        if (this.b != null) {
            anVar.a("st_param", this.b);
        }
        anVar.l();
    }
}
