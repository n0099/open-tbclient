package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class o {
    public String BDUSS;
    public String asp;

    public o(String str, String str2) {
        this.BDUSS = "";
        this.asp = "";
        this.BDUSS = str;
        this.asp = str2;
    }

    public int hashCode() {
        return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.asp != null ? this.asp.hashCode() : 0);
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
            return this.asp == null ? oVar.asp == null : this.asp.equals(oVar.asp);
        }
        return false;
    }
}
