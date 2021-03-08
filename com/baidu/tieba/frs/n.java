package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jhN = BdUniqueId.gen();
    private int height = 0;
    private int jhO = 0;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jhN;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int cCx() {
        return this.jhO;
    }

    public void yw(int i) {
        this.jhO = i;
    }
}
