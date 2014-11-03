package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.base.h;
/* loaded from: classes.dex */
public class a {
    private b LE;
    private h mLoadDataCallBack;

    public a(h hVar) {
        this.mLoadDataCallBack = hVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.LE == null) {
            this.LE = new b(this, null);
            this.LE.setPriority(2);
            this.LE.ag(z);
            this.LE.setPortrait(str);
            this.LE.setToUid(str2);
            this.LE.execute(new Integer[0]);
        }
    }

    public void cancel() {
        if (this.LE != null) {
            this.LE.cancel();
        }
    }
}
