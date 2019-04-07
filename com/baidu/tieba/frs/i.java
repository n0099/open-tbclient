package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId eYo = BdUniqueId.gen();
    private int height = 0;
    private int eYp = 0;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eYo;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bci() {
        return this.eYp;
    }

    public void pP(int i) {
        this.eYp = i;
    }
}
