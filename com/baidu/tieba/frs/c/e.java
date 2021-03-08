package com.baidu.tieba.frs.c;
/* loaded from: classes.dex */
public class e {
    private boolean jKC;
    private boolean jKD;
    private boolean jrM;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.jrM = false;
            this.jKC = true;
            return;
        }
        this.jrM = str.substring(0, 1).contains("1");
        this.jKC = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.jKD = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.jrM = z;
        this.jKC = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.jrM ? 1 : 0);
        objArr[1] = Integer.valueOf(this.jKC ? 1 : 0);
        objArr[2] = Integer.valueOf(this.jKD ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cKF() {
        return this.jrM;
    }

    public void rx(boolean z) {
        this.jrM = z;
    }

    public boolean cKG() {
        return this.jKC;
    }

    public void ry(boolean z) {
        this.jKC = z;
    }

    public void rz(boolean z) {
        this.jKD = z;
    }

    public boolean cKH() {
        return this.jKD;
    }
}
