package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jeR = BdUniqueId.gen();
    private int height = 0;
    private int jeS = 0;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jeR;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int cEQ() {
        return this.jeS;
    }

    public void zR(int i) {
        this.jeS = i;
    }
}
