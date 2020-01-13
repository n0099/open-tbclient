package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean gIE;
    private boolean gIF;
    private boolean gue;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.gue = false;
            this.gIE = true;
            return;
        }
        this.gue = str.substring(0, 1).contains("1");
        this.gIE = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.gIF = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.gue = z;
        this.gIE = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.gue ? 1 : 0);
        objArr[1] = Integer.valueOf(this.gIE ? 1 : 0);
        objArr[2] = Integer.valueOf(this.gIF ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bIs() {
        return this.gue;
    }

    public void lZ(boolean z) {
        this.gue = z;
    }

    public boolean bIt() {
        return this.gIE;
    }

    public void ma(boolean z) {
        this.gIE = z;
    }

    public void mb(boolean z) {
        this.gIF = z;
    }

    public boolean bIu() {
        return this.gIF;
    }
}
