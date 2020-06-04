package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId hnc = BdUniqueId.gen();
    private int height = 0;
    private int hnd = 0;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hnc;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int bUJ() {
        return this.hnd;
    }

    public void tH(int i) {
        this.hnd = i;
    }
}
