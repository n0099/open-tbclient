package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId djk = BdUniqueId.gen();
    private int height = 0;
    private int djl = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return djk;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int aty() {
        return this.djl;
    }

    public void kf(int i) {
        this.djl = i;
    }
}
