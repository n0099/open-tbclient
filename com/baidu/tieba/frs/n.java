package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iSE = BdUniqueId.gen();
    private int height = 0;
    private int iSF = 0;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iSE;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int cBU() {
        return this.iSF;
    }

    public void zE(int i) {
        this.iSF = i;
    }
}
