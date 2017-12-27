package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dwt = BdUniqueId.gen();
    private int height = 0;
    private int dwu = 0;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dwt;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int asL() {
        return this.dwu;
    }

    public void mN(int i) {
        this.dwu = i;
    }
}
