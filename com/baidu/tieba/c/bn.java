package com.baidu.tieba.c;
/* loaded from: classes.dex */
public class bn extends com.baidu.adp.a.c {
    private String e = null;
    private String f = null;
    private bo g = null;

    public void d() {
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
    }

    public void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.g == null) {
            this.e = str;
            this.f = str2;
            this.g = new bo(this, null);
            this.g.setPriority(2);
            this.g.execute(new Object[0]);
        }
    }
}
