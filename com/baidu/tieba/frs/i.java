package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eYp = BdUniqueId.gen();
    private int height = 0;
    private int eYq = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eYp;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bci() {
        return this.eYq;
    }

    public void pP(int i) {
        this.eYq = i;
    }
}
