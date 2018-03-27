package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dDZ = BdUniqueId.gen();
    private int height = 0;
    private int dEa = 0;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dDZ;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int auJ() {
        return this.dEa;
    }

    public void mN(int i) {
        this.dEa = i;
    }
}
