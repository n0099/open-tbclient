package com.baidu.tbadk.coreExtra.c;
/* loaded from: classes.dex */
public class a {
    private b abR;
    private com.baidu.adp.base.i mLoadDataCallBack;

    public a(com.baidu.adp.base.i iVar) {
        this.mLoadDataCallBack = iVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.abR == null) {
            this.abR = new b(this, null);
            this.abR.setPriority(2);
            this.abR.aC(z);
            this.abR.setPortrait(str);
            this.abR.setToUid(str2);
            this.abR.execute(new Integer[0]);
        }
    }

    public void cancel() {
        if (this.abR != null) {
            this.abR.cancel();
        }
    }
}
