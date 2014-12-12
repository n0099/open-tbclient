package com.baidu.tbadk.coreExtra.c;
/* loaded from: classes.dex */
public class a {
    private b Rg;
    private com.baidu.adp.base.i mLoadDataCallBack;

    public a(com.baidu.adp.base.i iVar) {
        this.mLoadDataCallBack = iVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.Rg == null) {
            this.Rg = new b(this, null);
            this.Rg.setPriority(2);
            this.Rg.au(z);
            this.Rg.setPortrait(str);
            this.Rg.setToUid(str2);
            this.Rg.execute(new Integer[0]);
        }
    }

    public void cancel() {
        if (this.Rg != null) {
            this.Rg.cancel();
        }
    }
}
