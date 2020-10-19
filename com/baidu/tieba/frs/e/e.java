package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean iOD;
    private boolean iOE;
    private boolean iyx;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.iyx = false;
            this.iOD = true;
            return;
        }
        this.iyx = str.substring(0, 1).contains("1");
        this.iOD = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.iOE = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.iyx = z;
        this.iOD = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.iyx ? 1 : 0);
        objArr[1] = Integer.valueOf(this.iOD ? 1 : 0);
        objArr[2] = Integer.valueOf(this.iOE ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean czu() {
        return this.iyx;
    }

    public void pO(boolean z) {
        this.iyx = z;
    }

    public boolean czv() {
        return this.iOD;
    }

    public void pP(boolean z) {
        this.iOD = z;
    }

    public void pQ(boolean z) {
        this.iOE = z;
    }

    public boolean czw() {
        return this.iOE;
    }
}
