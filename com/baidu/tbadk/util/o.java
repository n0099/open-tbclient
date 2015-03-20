package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class o {
    public String BDUSS;
    public String aqF;

    public o(String str, String str2) {
        this.BDUSS = "";
        this.aqF = "";
        this.BDUSS = str;
        this.aqF = str2;
    }

    public int hashCode() {
        return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.aqF != null ? this.aqF.hashCode() : 0);
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
            return this.aqF == null ? oVar.aqF == null : this.aqF.equals(oVar.aqF);
        }
        return false;
    }
}
