package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean fKZ;
    private boolean fLa;
    private boolean fwN;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.fwN = false;
            this.fKZ = true;
            return;
        }
        this.fwN = str.substring(0, 1).contains("1");
        this.fKZ = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.fLa = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.fwN = z;
        this.fKZ = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.fwN ? 1 : 0);
        objArr[1] = Integer.valueOf(this.fKZ ? 1 : 0);
        objArr[2] = Integer.valueOf(this.fLa ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bpS() {
        return this.fwN;
    }

    public void kC(boolean z) {
        this.fwN = z;
    }

    public boolean bpT() {
        return this.fKZ;
    }

    public void kD(boolean z) {
        this.fKZ = z;
    }

    public void kE(boolean z) {
        this.fLa = z;
    }

    public boolean bpU() {
        return this.fLa;
    }
}
