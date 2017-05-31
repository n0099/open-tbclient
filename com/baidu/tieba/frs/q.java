package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bTL = BdUniqueId.gen();
    private int height = 0;
    private int bpa = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bTL;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int ZT() {
        return this.bpa;
    }

    /* renamed from: if  reason: not valid java name */
    public void m15if(int i) {
        this.bpa = i;
    }
}
