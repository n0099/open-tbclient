package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class o {
    public String BDUSS;
    public String aqN;

    public o(String str, String str2) {
        this.BDUSS = "";
        this.aqN = "";
        this.BDUSS = str;
        this.aqN = str2;
    }

    public int hashCode() {
        return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.aqN != null ? this.aqN.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            o oVar = (o) obj;
            if (this.BDUSS == null) {
                if (oVar.BDUSS != null) {
                    return false;
                }
            } else if (!this.BDUSS.equals(oVar.BDUSS)) {
                return false;
            }
            return this.aqN == null ? oVar.aqN == null : this.aqN.equals(oVar.aqN);
        }
        return false;
    }
}
