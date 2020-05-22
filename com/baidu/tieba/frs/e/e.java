package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean hKh;
    private boolean hKi;
    private boolean hvg;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.hvg = false;
            this.hKh = true;
            return;
        }
        this.hvg = str.substring(0, 1).contains("1");
        this.hKh = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.hKi = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.hvg = z;
        this.hKh = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.hvg ? 1 : 0);
        objArr[1] = Integer.valueOf(this.hKh ? 1 : 0);
        objArr[2] = Integer.valueOf(this.hKi ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cbd() {
        return this.hvg;
    }

    public void nG(boolean z) {
        this.hvg = z;
    }

    public boolean cbe() {
        return this.hKh;
    }

    public void nH(boolean z) {
        this.hKh = z;
    }

    public void nI(boolean z) {
        this.hKi = z;
    }

    public boolean cbf() {
        return this.hKi;
    }
}
