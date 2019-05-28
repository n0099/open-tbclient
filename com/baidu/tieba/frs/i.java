package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId foA = BdUniqueId.gen();
    private int height = 0;
    private int foB = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return foA;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bjF() {
        return this.foB;
    }

    public void qV(int i) {
        this.foB = i;
    }
}
