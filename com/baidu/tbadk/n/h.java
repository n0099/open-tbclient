package com.baidu.tbadk.n;
/* loaded from: classes.dex */
public class h extends g {
    public long costTime;
    public boolean dDW;
    public boolean isSuccess;
    public String resourceFromType;

    public void aRl() {
        o oVar;
        if (m.aRq().aRr() && (oVar = (o) m.aRq().mP(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void aRm() {
        o oVar;
        if (m.aRq().aRr() && (oVar = (o) m.aRq().mP(this.mSubType)) != null) {
            oVar.a(this, "img");
        }
    }
}
