package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class p {
    public String BDUSS;
    public String aie;

    public p(String str, String str2) {
        this.BDUSS = "";
        this.aie = "";
        this.BDUSS = str;
        this.aie = str2;
    }

    public int hashCode() {
        return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.aie != null ? this.aie.hashCode() : 0);
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
            return this.aie == null ? pVar.aie == null : this.aie.equals(pVar.aie);
        }
        return false;
    }
}
