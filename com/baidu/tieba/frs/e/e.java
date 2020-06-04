package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean hKU;
    private boolean hKV;
    private boolean hvr;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.hvr = false;
            this.hKU = true;
            return;
        }
        this.hvr = str.substring(0, 1).contains("1");
        this.hKU = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.hKV = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.hvr = z;
        this.hKU = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.hvr ? 1 : 0);
        objArr[1] = Integer.valueOf(this.hKU ? 1 : 0);
        objArr[2] = Integer.valueOf(this.hKV ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cbl() {
        return this.hvr;
    }

    public void nG(boolean z) {
        this.hvr = z;
    }

    public boolean cbm() {
        return this.hKU;
    }

    public void nH(boolean z) {
        this.hKU = z;
    }

    public void nI(boolean z) {
        this.hKV = z;
    }

    public boolean cbn() {
        return this.hKV;
    }
}
