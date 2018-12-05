package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dHN = BdUniqueId.gen();
    private int height = 0;
    private int dHO = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dHN;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int aAy() {
        return this.dHO;
    }

    public void lU(int i) {
        this.dHO = i;
    }
}
