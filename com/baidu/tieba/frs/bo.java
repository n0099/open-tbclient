package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bo implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId aVW = BdUniqueId.gen();
    private int height = 0;
    private int aVX = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aVW;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int LD() {
        return this.aVX;
    }

    public void fv(int i) {
        this.aVX = i;
    }
}
