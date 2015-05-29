package com.baidu.tbadk.coreExtra.c;
/* loaded from: classes.dex */
public class a {
    private b acW;
    private com.baidu.adp.base.i mLoadDataCallBack;

    public a(com.baidu.adp.base.i iVar) {
        this.mLoadDataCallBack = iVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.acW == null) {
            this.acW = new b(this, null);
            this.acW.setPriority(2);
            this.acW.aJ(z);
            this.acW.setPortrait(str);
            this.acW.setToUid(str2);
            this.acW.execute(new Integer[0]);
        }
    }

    public void cancel() {
        if (this.acW != null) {
            this.acW.cancel();
        }
    }
}
