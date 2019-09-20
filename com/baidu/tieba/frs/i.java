package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fvL = BdUniqueId.gen();
    private int height = 0;
    private int fvM = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fvL;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bmz() {
        return this.fvM;
    }

    public void rs(int i) {
        this.fvM = i;
    }
}
