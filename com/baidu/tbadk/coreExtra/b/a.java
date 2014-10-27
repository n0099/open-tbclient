package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.base.h;
/* loaded from: classes.dex */
public class a {
    private b LB;
    private h mLoadDataCallBack;

    public a(h hVar) {
        this.mLoadDataCallBack = hVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.LB == null) {
            this.LB = new b(this, null);
            this.LB.setPriority(2);
            this.LB.ag(z);
            this.LB.setPortrait(str);
            this.LB.setToUid(str2);
            this.LB.execute(new Integer[0]);
        }
    }

    public void cancel() {
        if (this.LB != null) {
            this.LB.cancel();
        }
    }
}
