package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean fCK;
    private boolean fRe;
    private boolean fRf;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.fCK = false;
            this.fRe = true;
            return;
        }
        this.fCK = str.substring(0, 1).contains("1");
        this.fRe = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.fRf = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.fCK = z;
        this.fRe = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.fCK ? 1 : 0);
        objArr[1] = Integer.valueOf(this.fRe ? 1 : 0);
        objArr[2] = Integer.valueOf(this.fRf ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bpV() {
        return this.fCK;
    }

    public void kC(boolean z) {
        this.fCK = z;
    }

    public boolean bpW() {
        return this.fRe;
    }

    public void kD(boolean z) {
        this.fRe = z;
    }

    public void kE(boolean z) {
        this.fRf = z;
    }

    public boolean bpX() {
        return this.fRf;
    }
}
