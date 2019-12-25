package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean gFp;
    private boolean gFq;
    private boolean gqV;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.gqV = false;
            this.gFp = true;
            return;
        }
        this.gqV = str.substring(0, 1).contains("1");
        this.gFp = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.gFq = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.gqV = z;
        this.gFp = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.gqV ? 1 : 0);
        objArr[1] = Integer.valueOf(this.gFp ? 1 : 0);
        objArr[2] = Integer.valueOf(this.gFq ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bHq() {
        return this.gqV;
    }

    public void lO(boolean z) {
        this.gqV = z;
    }

    public boolean bHr() {
        return this.gFp;
    }

    public void lP(boolean z) {
        this.gFp = z;
    }

    public void lQ(boolean z) {
        this.gFq = z;
    }

    public boolean bHs() {
        return this.gFq;
    }
}
