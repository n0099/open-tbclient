package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean iRD;
    private boolean jhH;
    private boolean jhI;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.iRD = false;
            this.jhH = true;
            return;
        }
        this.iRD = str.substring(0, 1).contains("1");
        this.jhH = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.jhI = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.iRD = z;
        this.jhH = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.iRD ? 1 : 0);
        objArr[1] = Integer.valueOf(this.jhH ? 1 : 0);
        objArr[2] = Integer.valueOf(this.jhI ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cEH() {
        return this.iRD;
    }

    public void qs(boolean z) {
        this.iRD = z;
    }

    public boolean cEI() {
        return this.jhH;
    }

    public void qt(boolean z) {
        this.jhH = z;
    }

    public void qu(boolean z) {
        this.jhI = z;
    }

    public boolean cEJ() {
        return this.jhI;
    }
}
