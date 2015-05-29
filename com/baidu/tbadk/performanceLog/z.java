package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class z extends y {
    public String Go;
    public long Gp;
    public boolean aqw;
    public boolean isSuccess;

    public void Dt() {
        aj ajVar;
        if (ah.DB().DC() && (ajVar = (aj) ah.DB().en(this.mSubType)) != null) {
            ajVar.a(this, "head");
        }
    }

    public void Du() {
        aj ajVar;
        if (ah.DB().DC() && (ajVar = (aj) ah.DB().en(this.mSubType)) != null) {
            ajVar.a(this, "img");
        }
    }
}
