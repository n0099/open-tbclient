package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean hOj;
    private boolean iei;
    private boolean iej;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.hOj = false;
            this.iei = true;
            return;
        }
        this.hOj = str.substring(0, 1).contains("1");
        this.iei = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.iej = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.hOj = z;
        this.iei = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.hOj ? 1 : 0);
        objArr[1] = Integer.valueOf(this.iei ? 1 : 0);
        objArr[2] = Integer.valueOf(this.iej ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cid() {
        return this.hOj;
    }

    public void ox(boolean z) {
        this.hOj = z;
    }

    public boolean cie() {
        return this.iei;
    }

    public void oy(boolean z) {
        this.iei = z;
    }

    public void oz(boolean z) {
        this.iej = z;
    }

    public boolean cif() {
        return this.iej;
    }
}
