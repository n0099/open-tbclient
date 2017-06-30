package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId cbT = BdUniqueId.gen();
    private int height = 0;
    private int cbU = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cbT;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int adK() {
        return this.cbU;
    }

    public void ir(int i) {
        this.cbU = i;
    }
}
