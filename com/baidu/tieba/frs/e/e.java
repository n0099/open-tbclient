package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean gKD;
    private boolean gKE;
    private boolean gwf;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.gwf = false;
            this.gKD = true;
            return;
        }
        this.gwf = str.substring(0, 1).contains("1");
        this.gKD = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.gKE = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.gwf = z;
        this.gKD = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.gwf ? 1 : 0);
        objArr[1] = Integer.valueOf(this.gKD ? 1 : 0);
        objArr[2] = Integer.valueOf(this.gKE ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bJU() {
        return this.gwf;
    }

    public void mb(boolean z) {
        this.gwf = z;
    }

    public boolean bJV() {
        return this.gKD;
    }

    public void mc(boolean z) {
        this.gKD = z;
    }

    public void md(boolean z) {
        this.gKE = z;
    }

    public boolean bJW() {
        return this.gKE;
    }
}
