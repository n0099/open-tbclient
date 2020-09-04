package com.baidu.tbadk.n;
/* loaded from: classes.dex */
public class h extends g {
    public long costTime;
    public boolean eRM;
    public boolean isSuccess;
    public String resourceFromType;

    public void buj() {
        o oVar;
        if (m.buo().bup() && (oVar = (o) m.buo().qC(this.mSubType)) != null) {
            oVar.a(this, "head");
        }
    }

    public void buk() {
        o oVar;
        if (m.buo().bup() && (oVar = (o) m.buo().qC(this.mSubType)) != null) {
            oVar.a(this, "img");
        }
    }
}
