package com.baidu.tbadk.coreExtra.c;
/* loaded from: classes.dex */
public class a {
    private b RK;
    private com.baidu.adp.base.i mLoadDataCallBack;

    public a(com.baidu.adp.base.i iVar) {
        this.mLoadDataCallBack = iVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.RK == null) {
            this.RK = new b(this, null);
            this.RK.setPriority(2);
            this.RK.aw(z);
            this.RK.setPortrait(str);
            this.RK.setToUid(str2);
            this.RK.execute(new Integer[0]);
        }
    }

    public void cancel() {
        if (this.RK != null) {
            this.RK.cancel();
        }
    }
}
