package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eYD = BdUniqueId.gen();
    private int height = 0;
    private int eYE = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eYD;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bcl() {
        return this.eYE;
    }

    public void pT(int i) {
        this.eYE = i;
    }
}
