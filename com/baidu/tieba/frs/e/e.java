package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean icw;
    private boolean isu;
    private boolean isv;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.icw = false;
            this.isu = true;
            return;
        }
        this.icw = str.substring(0, 1).contains("1");
        this.isu = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.isv = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.icw = z;
        this.isu = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.icw ? 1 : 0);
        objArr[1] = Integer.valueOf(this.isu ? 1 : 0);
        objArr[2] = Integer.valueOf(this.isv ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean csI() {
        return this.icw;
    }

    public void pd(boolean z) {
        this.icw = z;
    }

    public boolean csJ() {
        return this.isu;
    }

    public void pe(boolean z) {
        this.isu = z;
    }

    public void pf(boolean z) {
        this.isv = z;
    }

    public boolean csK() {
        return this.isv;
    }
}
