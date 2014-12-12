package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class m {
    public String BDUSS;
    public String ahF;

    public m(String str, String str2) {
        this.BDUSS = "";
        this.ahF = "";
        this.BDUSS = str;
        this.ahF = str2;
    }

    public int hashCode() {
        return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.ahF != null ? this.ahF.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            m mVar = (m) obj;
            if (this.BDUSS == null) {
                if (mVar.BDUSS != null) {
                    return false;
                }
            } else if (!this.BDUSS.equals(mVar.BDUSS)) {
                return false;
            }
            return this.ahF == null ? mVar.ahF == null : this.ahF.equals(mVar.ahF);
        }
        return false;
    }
}
