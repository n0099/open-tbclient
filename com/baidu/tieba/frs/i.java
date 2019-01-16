package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dLk = BdUniqueId.gen();
    private int height = 0;
    private int dLl = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dLk;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int aBK() {
        return this.dLl;
    }

    public void mi(int i) {
        this.dLl = i;
    }
}
