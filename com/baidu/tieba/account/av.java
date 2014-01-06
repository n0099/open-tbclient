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
        String str2;
        super.run();
        if (this.c) {
            str = "c/s/inpv";
        } else {
            str = "c/s/pv";
        }
        com.baidu.tieba.util.at atVar = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + str);
        if (this.c) {
            str2 = null;
        } else {
            str2 = com.baidu.tieba.util.bd.a().d();
            if (!com.baidu.tieba.util.bm.c(str2)) {
                com.baidu.tieba.util.bd.a().c();
                atVar.a("st_record", str2);
            }
        }
        atVar.a("st_type", this.a);
        if (this.b != null) {
            atVar.a("st_param", this.b);
        }
        atVar.l();
        if (this.c) {
            return;
        }
        if (!atVar.c() || atVar.e() != 0) {
            com.baidu.tieba.util.bd.a().b(str2);
        }
    }
}
