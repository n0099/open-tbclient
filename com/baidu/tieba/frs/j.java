package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gnV = BdUniqueId.gen();
    private int height = 0;
    private int gnW = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gnV;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bDF() {
        return this.gnW;
    }

    public void sB(int i) {
        this.gnW = i;
    }
}
