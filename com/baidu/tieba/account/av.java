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
        com.baidu.tieba.util.ax axVar = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + str);
        if (this.c) {
            str2 = null;
        } else {
            str2 = com.baidu.tieba.util.bh.a().d();
            if (!com.baidu.tieba.util.bu.c(str2)) {
                com.baidu.tieba.util.bh.a().c();
                axVar.a("st_record", str2);
            }
        }
        axVar.a("st_type", this.a);
        if (this.b != null) {
            axVar.a("st_param", this.b);
        }
        axVar.m();
        if (this.c) {
            return;
        }
        if (!axVar.d() || axVar.f() != 0) {
            com.baidu.tieba.util.bh.a().b(str2);
        }
    }
}
