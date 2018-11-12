package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dBo = BdUniqueId.gen();
    private int height = 0;
    private int dBp = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dBo;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int ayO() {
        return this.dBp;
    }

    public void lE(int i) {
        this.dBp = i;
    }
}
