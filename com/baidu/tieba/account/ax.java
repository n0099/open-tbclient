package com.baidu.tieba.account;
/* loaded from: classes.dex */
public final class ax extends Thread {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;

    public ax(String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.e = false;
    }

    public ax(String str, String str2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.b = str2;
    }

    public ax(String str, String str2, String str3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        super.run();
        if (this.e) {
            str = "c/s/inpv";
        } else {
            str = "c/s/pv";
        }
        com.baidu.tieba.util.ba baVar = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + str);
        if (this.e) {
            str2 = null;
        } else {
            str2 = com.baidu.tieba.util.bg.a().d();
            if (!com.baidu.tieba.util.bs.c(str2)) {
                com.baidu.tieba.util.bg.a().c();
                baVar.a("st_record", str2);
            }
        }
        baVar.a("st_type", this.a);
        if (this.b != null) {
            baVar.a("st_param", this.b);
        }
        if (this.c != null) {
            baVar.a("obj", this.c);
        }
        if (this.d != null) {
            baVar.a("obj_tp", this.d);
        }
        baVar.l();
        if (this.e) {
            return;
        }
        if (!baVar.c() || baVar.e() != 0) {
            com.baidu.tieba.util.bg.a().b(str2);
        }
    }
}
