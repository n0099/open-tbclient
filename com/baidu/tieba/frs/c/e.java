package com.baidu.tieba.frs.c;
/* loaded from: classes.dex */
public class e {
    private boolean jIF;
    private boolean jIG;
    private boolean jpP;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.jpP = false;
            this.jIF = true;
            return;
        }
        this.jpP = str.substring(0, 1).contains("1");
        this.jIF = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.jIG = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.jpP = z;
        this.jIF = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.jpP ? 1 : 0);
        objArr[1] = Integer.valueOf(this.jIF ? 1 : 0);
        objArr[2] = Integer.valueOf(this.jIG ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cKs() {
        return this.jpP;
    }

    public void rx(boolean z) {
        this.jpP = z;
    }

    public boolean cKt() {
        return this.jIF;
    }

    public void ry(boolean z) {
        this.jIF = z;
    }

    public void rz(boolean z) {
        this.jIG = z;
    }

    public boolean cKu() {
        return this.jIG;
    }
}
