package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bd implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId aWm = BdUniqueId.gen();
    private int height = 0;
    private int aWn = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aWm;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int LL() {
        return this.aWn;
    }

    public void fi(int i) {
        this.aWn = i;
    }
}
