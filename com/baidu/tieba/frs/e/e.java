package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean fCx;
    private boolean fQL;
    private boolean fQM;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.fCx = false;
            this.fQL = true;
            return;
        }
        this.fCx = str.substring(0, 1).contains("1");
        this.fQL = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.fQM = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.fCx = z;
        this.fQL = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.fCx ? 1 : 0);
        objArr[1] = Integer.valueOf(this.fQL ? 1 : 0);
        objArr[2] = Integer.valueOf(this.fQM ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bsg() {
        return this.fCx;
    }

    public void kM(boolean z) {
        this.fCx = z;
    }

    public boolean bsh() {
        return this.fQL;
    }

    public void kN(boolean z) {
        this.fQL = z;
    }

    public void kO(boolean z) {
        this.fQM = z;
    }

    public boolean bsi() {
        return this.fQM;
    }
}
