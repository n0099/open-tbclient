package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jge = BdUniqueId.gen();
    private int height = 0;
    private int jgf = 0;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jge;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int cCr() {
        return this.jgf;
    }

    public void yv(int i) {
        this.jgf = i;
    }
}
