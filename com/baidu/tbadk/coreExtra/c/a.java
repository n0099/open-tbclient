package com.baidu.tbadk.coreExtra.c;
/* loaded from: classes.dex */
public class a {
    private b abJ;
    private com.baidu.adp.base.i mLoadDataCallBack;

    public a(com.baidu.adp.base.i iVar) {
        this.mLoadDataCallBack = iVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.abJ == null) {
            this.abJ = new b(this, null);
            this.abJ.setPriority(2);
            this.abJ.aC(z);
            this.abJ.setPortrait(str);
            this.abJ.setToUid(str2);
            this.abJ.execute(new Integer[0]);
        }
    }

    public void cancel() {
        if (this.abJ != null) {
            this.abJ.cancel();
        }
    }
}
