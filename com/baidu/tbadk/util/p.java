package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class p {
    public String BDUSS;
    public String aih;

    public p(String str, String str2) {
        this.BDUSS = "";
        this.aih = "";
        this.BDUSS = str;
        this.aih = str2;
    }

    public int hashCode() {
        return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.aih != null ? this.aih.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            p pVar = (p) obj;
            if (this.BDUSS == null) {
                if (pVar.BDUSS != null) {
                    return false;
                }
            } else if (!this.BDUSS.equals(pVar.BDUSS)) {
                return false;
            }
            return this.aih == null ? pVar.aih == null : this.aih.equals(pVar.aih);
        }
        return false;
    }
}
