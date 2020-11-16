package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iHM = BdUniqueId.gen();
    private int height = 0;
    private int iHN = 0;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iHM;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int cxE() {
        return this.iHN;
    }

    public void yZ(int i) {
        this.iHN = i;
    }
}
