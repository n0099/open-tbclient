package com.baidu.tieba.frs.e;
/* loaded from: classes2.dex */
public class e {
    private boolean icq;
    private boolean iso;
    private boolean isp;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.icq = false;
            this.iso = true;
            return;
        }
        this.icq = str.substring(0, 1).contains("1");
        this.iso = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.isp = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.icq = z;
        this.iso = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.icq ? 1 : 0);
        objArr[1] = Integer.valueOf(this.iso ? 1 : 0);
        objArr[2] = Integer.valueOf(this.isp ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean csH() {
        return this.icq;
    }

    public void pb(boolean z) {
        this.icq = z;
    }

    public boolean csI() {
        return this.iso;
    }

    public void pc(boolean z) {
        this.iso = z;
    }

    public void pd(boolean z) {
        this.isp = z;
    }

    public boolean csJ() {
        return this.isp;
    }
}
