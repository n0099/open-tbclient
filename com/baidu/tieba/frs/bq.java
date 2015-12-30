package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bq implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId bfF = BdUniqueId.gen();
    private int height = 0;
    private int bfG = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bfF;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int NH() {
        return this.bfG;
    }

    public void fU(int i) {
        this.bfG = i;
    }
}
