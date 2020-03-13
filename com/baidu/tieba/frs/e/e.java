package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean gKR;
    private boolean gKS;
    private boolean gwt;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.gwt = false;
            this.gKR = true;
            return;
        }
        this.gwt = str.substring(0, 1).contains("1");
        this.gKR = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.gKS = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.gwt = z;
        this.gKR = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.gwt ? 1 : 0);
        objArr[1] = Integer.valueOf(this.gKR ? 1 : 0);
        objArr[2] = Integer.valueOf(this.gKS ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bJX() {
        return this.gwt;
    }

    public void mb(boolean z) {
        this.gwt = z;
    }

    public boolean bJY() {
        return this.gKR;
    }

    public void mc(boolean z) {
        this.gKR = z;
    }

    public void md(boolean z) {
        this.gKS = z;
    }

    public boolean bJZ() {
        return this.gKS;
    }
}
