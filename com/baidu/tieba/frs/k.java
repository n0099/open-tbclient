package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hmR = BdUniqueId.gen();
    private int height = 0;
    private int hmS = 0;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hmR;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bUH() {
        return this.hmS;
    }

    public void tF(int i) {
        this.hmS = i;
    }
}
