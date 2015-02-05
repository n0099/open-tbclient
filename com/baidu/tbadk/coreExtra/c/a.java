package com.baidu.tbadk.coreExtra.c;
/* loaded from: classes.dex */
public class a {
    private b RH;
    private com.baidu.adp.base.i mLoadDataCallBack;

    public a(com.baidu.adp.base.i iVar) {
        this.mLoadDataCallBack = iVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.RH == null) {
            this.RH = new b(this, null);
            this.RH.setPriority(2);
            this.RH.aw(z);
            this.RH.setPortrait(str);
            this.RH.setToUid(str2);
            this.RH.execute(new Integer[0]);
        }
    }

    public void cancel() {
        if (this.RH != null) {
            this.RH.cancel();
        }
    }
}
