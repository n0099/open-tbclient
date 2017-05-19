package com.baidu.tbadk.j;
/* loaded from: classes.dex */
public class u extends t {
    public String Hf;
    public long Hg;
    public boolean aGB;
    public boolean isSuccess;

    public void FD() {
        ac acVar;
        if (aa.FK().FL() && (acVar = (ac) aa.FK().fc(this.mSubType)) != null) {
            acVar.a(this, "head");
        }
    }

    public void FE() {
        ac acVar;
        if (aa.FK().FL() && (acVar = (ac) aa.FK().fc(this.mSubType)) != null) {
            acVar.a(this, "img");
        }
    }
}
