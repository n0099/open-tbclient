package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bNY = BdUniqueId.gen();
    private int height = 0;
    private int bnT = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bNY;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int YP() {
        return this.bnT;
    }

    public void hH(int i) {
        this.bnT = i;
    }
}
