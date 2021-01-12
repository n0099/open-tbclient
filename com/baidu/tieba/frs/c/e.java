package com.baidu.tieba.frs.c;
/* loaded from: classes.dex */
public class e {
    private boolean jDb;
    private boolean jDc;
    private boolean jki;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.jki = false;
            this.jDb = true;
            return;
        }
        this.jki = str.substring(0, 1).contains("1");
        this.jDb = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.jDc = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.jki = z;
        this.jDb = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.jki ? 1 : 0);
        objArr[1] = Integer.valueOf(this.jDb ? 1 : 0);
        objArr[2] = Integer.valueOf(this.jDc ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cJf() {
        return this.jki;
    }

    public void rn(boolean z) {
        this.jki = z;
    }

    public boolean cJg() {
        return this.jDb;
    }

    public void ro(boolean z) {
        this.jDb = z;
    }

    public void rp(boolean z) {
        this.jDc = z;
    }

    public boolean cJh() {
        return this.jDc;
    }
}
