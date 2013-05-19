package com.baidu.tieba.c;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.a.c {
    private j e = null;
    private l f = null;
    private n g = null;

    public boolean d() {
        e();
        return false;
    }

    public void e() {
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2) {
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
        this.a = 0;
        this.e = new j(this, str, str2, str3, str4, i, i2);
        this.e.setPriority(2);
        this.e.execute(new String[0]);
    }

    public boolean f() {
        return (this.e == null && this.f == null && this.g == null) ? false : true;
    }

    public void a(String str, String str2, String str3, String str4, int i) {
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
        this.a = 1;
        this.f = new l(this, str, str2, str3, str4, String.valueOf(i));
        this.f.setPriority(2);
        this.f.execute(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/bawu/commitprison");
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
        this.a = i;
        this.g = new n(this, str, str2, str3, i, str4);
        this.g.setPriority(2);
        String str6 = com.baidu.tieba.a.i.e;
        if (i == 6) {
            str5 = String.valueOf(str6) + "c/c/bawu/goodlist";
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + "c/c/bawu/commitgood";
        } else {
            str5 = String.valueOf(str6) + "c/c/bawu/committop";
        }
        this.g.execute(str5);
    }
}
