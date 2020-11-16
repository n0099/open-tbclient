package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class n implements q {
    public static final BdUniqueId aiE = BdUniqueId.gen();
    private boolean cuK = false;
    private String flx;
    private String fly;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return aiE;
    }

    public String byn() {
        return this.flx;
    }

    public void CU(String str) {
        this.flx = str;
    }

    public String getSmallUrl() {
        return this.fly;
    }

    public void CV(String str) {
        this.fly = str;
    }

    public boolean byo() {
        return this.cuK;
    }

    public void jU(boolean z) {
        this.cuK = z;
    }
}
