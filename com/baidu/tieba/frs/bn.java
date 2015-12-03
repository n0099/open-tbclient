package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bn implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId bbG = BdUniqueId.gen();
    private int height = 0;
    private int bbH = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bbG;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int No() {
        return this.bbH;
    }

    public void fZ(int i) {
        this.bbH = i;
    }
}
