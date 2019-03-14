package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eYC = BdUniqueId.gen();
    private int height = 0;
    private int eYD = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eYC;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bck() {
        return this.eYD;
    }

    public void pT(int i) {
        this.eYD = i;
    }
}
