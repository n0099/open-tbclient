package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class j {
    public String BDUSS;
    public String ZN;

    public j(String str, String str2) {
        this.BDUSS = "";
        this.ZN = "";
        this.BDUSS = str;
        this.ZN = str2;
    }

    public int hashCode() {
        return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.ZN != null ? this.ZN.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            j jVar = (j) obj;
            if (this.BDUSS == null) {
                if (jVar.BDUSS != null) {
                    return false;
                }
            } else if (!this.BDUSS.equals(jVar.BDUSS)) {
                return false;
            }
            return this.ZN == null ? jVar.ZN == null : this.ZN.equals(jVar.ZN);
        }
        return false;
    }
}
