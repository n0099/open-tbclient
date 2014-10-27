package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class j {
    public String BDUSS;
    public String ZJ;

    public j(String str, String str2) {
        this.BDUSS = "";
        this.ZJ = "";
        this.BDUSS = str;
        this.ZJ = str2;
    }

    public int hashCode() {
        return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.ZJ != null ? this.ZJ.hashCode() : 0);
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
            return this.ZJ == null ? jVar.ZJ == null : this.ZJ.equals(jVar.ZJ);
        }
        return false;
    }
}
