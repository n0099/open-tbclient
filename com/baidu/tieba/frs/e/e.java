package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean hOl;
    private boolean iek;
    private boolean iel;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.hOl = false;
            this.iek = true;
            return;
        }
        this.hOl = str.substring(0, 1).contains("1");
        this.iek = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.iel = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.hOl = z;
        this.iek = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.hOl ? 1 : 0);
        objArr[1] = Integer.valueOf(this.iek ? 1 : 0);
        objArr[2] = Integer.valueOf(this.iel ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cid() {
        return this.hOl;
    }

    public void ox(boolean z) {
        this.hOl = z;
    }

    public boolean cie() {
        return this.iek;
    }

    public void oy(boolean z) {
        this.iek = z;
    }

    public void oz(boolean z) {
        this.iel = z;
    }

    public boolean cif() {
        return this.iel;
    }
}
