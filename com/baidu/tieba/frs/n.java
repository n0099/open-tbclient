package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jfQ = BdUniqueId.gen();
    private int height = 0;
    private int jfR = 0;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jfQ;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int cCk() {
        return this.jfR;
    }

    public void yv(int i) {
        this.jfR = i;
    }
}
