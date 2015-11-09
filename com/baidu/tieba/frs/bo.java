package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bo implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId aWp = BdUniqueId.gen();
    private int height = 0;
    private int aWq = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aWp;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int LP() {
        return this.aWq;
    }

    public void fD(int i) {
        this.aWq = i;
    }
}
