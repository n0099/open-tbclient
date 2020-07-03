package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean hIj;
    private boolean hYg;
    private boolean hYh;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.hIj = false;
            this.hYg = true;
            return;
        }
        this.hIj = str.substring(0, 1).contains("1");
        this.hYg = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.hYh = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.hIj = z;
        this.hYg = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.hIj ? 1 : 0);
        objArr[1] = Integer.valueOf(this.hYg ? 1 : 0);
        objArr[2] = Integer.valueOf(this.hYh ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean ceD() {
        return this.hIj;
    }

    public void nS(boolean z) {
        this.hIj = z;
    }

    public boolean ceE() {
        return this.hYg;
    }

    public void nT(boolean z) {
        this.hYg = z;
    }

    public void nU(boolean z) {
        this.hYh = z;
    }

    public boolean ceF() {
        return this.hYh;
    }
}
