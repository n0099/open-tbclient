package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId ioF = BdUniqueId.gen();
    private int height = 0;
    private int ioG = 0;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ioF;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int cst() {
        return this.ioG;
    }

    public void xV(int i) {
        this.ioG = i;
    }
}
