package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dhn = BdUniqueId.gen();
    private int height = 0;
    private int dho = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dhn;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int ath() {
        return this.dho;
    }

    public void kb(int i) {
        this.dho = i;
    }
}
