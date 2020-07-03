package com.baidu.tbadk.n;
/* loaded from: classes.dex */
public class h extends g {
    public long costTime;
    public boolean eAN;
    public boolean isSuccess;
    public String resourceFromType;

    public void bhK() {
        o oVar;
        if (m.bhP().bhQ() && (oVar = (o) m.bhP().nZ(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void bhL() {
        o oVar;
        if (m.bhP().bhQ() && (oVar = (o) m.bhP().nZ(this.mSubType)) != null) {
            oVar.a(this, "img");
        }
    }
}
