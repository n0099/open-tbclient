package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean hgm;
    private boolean hvo;
    private boolean hvp;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.hgm = false;
            this.hvo = true;
            return;
        }
        this.hgm = str.substring(0, 1).contains("1");
        this.hvo = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.hvp = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.hgm = z;
        this.hvo = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.hgm ? 1 : 0);
        objArr[1] = Integer.valueOf(this.hvo ? 1 : 0);
        objArr[2] = Integer.valueOf(this.hvp ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bUH() {
        return this.hgm;
    }

    public void nl(boolean z) {
        this.hgm = z;
    }

    public boolean bUI() {
        return this.hvo;
    }

    public void nm(boolean z) {
        this.hvo = z;
    }

    public void nn(boolean z) {
        this.hvp = z;
    }

    public boolean bUJ() {
        return this.hvp;
    }
}
