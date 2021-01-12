package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jak = BdUniqueId.gen();
    private int height = 0;
    private int jal = 0;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jak;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int cAY() {
        return this.jal;
    }

    public void yl(int i) {
        this.jal = i;
    }
}
