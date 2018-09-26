package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId drV = BdUniqueId.gen();
    private int height = 0;
    private int drW = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return drV;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int avU() {
        return this.drW;
    }

    public void kO(int i) {
        this.drW = i;
    }
}
