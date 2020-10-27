package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean iKT;
    private boolean jaZ;
    private boolean jba;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.iKT = false;
            this.jaZ = true;
            return;
        }
        this.iKT = str.substring(0, 1).contains("1");
        this.jaZ = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.jba = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.iKT = z;
        this.jaZ = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.iKT ? 1 : 0);
        objArr[1] = Integer.valueOf(this.jaZ ? 1 : 0);
        objArr[2] = Integer.valueOf(this.jba ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cCB() {
        return this.iKT;
    }

    public void qg(boolean z) {
        this.iKT = z;
    }

    public boolean cCC() {
        return this.jaZ;
    }

    public void qh(boolean z) {
        this.jaZ = z;
    }

    public void qi(boolean z) {
        this.jba = z;
    }

    public boolean cCD() {
        return this.jba;
    }
}
