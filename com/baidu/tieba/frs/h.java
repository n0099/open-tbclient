package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dBp = BdUniqueId.gen();
    private int height = 0;
    private int dBq = 0;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dBp;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int atT() {
        return this.dBq;
    }

    public void mQ(int i) {
        this.dBq = i;
    }
}
