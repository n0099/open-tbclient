package com.baidu.tbadk.d;
/* loaded from: classes.dex */
public final class e {
    public String a;
    public String b;

    public e(String str, String str2) {
        this.a = "";
        this.b = "";
        this.a = str;
        this.b = str2;
    }

    public final int hashCode() {
        return (((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            e eVar = (e) obj;
            if (this.a == null) {
                if (eVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(eVar.a)) {
                return false;
            }
            return this.b == null ? eVar.b == null : this.b.equals(eVar.b);
        }
        return false;
    }
}
