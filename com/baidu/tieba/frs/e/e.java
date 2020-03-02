package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean gKF;
    private boolean gKG;
    private boolean gwh;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.gwh = false;
            this.gKF = true;
            return;
        }
        this.gwh = str.substring(0, 1).contains("1");
        this.gKF = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.gKG = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.gwh = z;
        this.gKF = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.gwh ? 1 : 0);
        objArr[1] = Integer.valueOf(this.gKF ? 1 : 0);
        objArr[2] = Integer.valueOf(this.gKG ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bJW() {
        return this.gwh;
    }

    public void mb(boolean z) {
        this.gwh = z;
    }

    public boolean bJX() {
        return this.gKF;
    }

    public void mc(boolean z) {
        this.gKF = z;
    }

    public void md(boolean z) {
        this.gKG = z;
    }

    public boolean bJY() {
        return this.gKG;
    }
}
