package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gnT = BdUniqueId.gen();
    private int height = 0;
    private int gnU = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gnT;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bDD() {
        return this.gnU;
    }

    public void sB(int i) {
        this.gnU = i;
    }
}
