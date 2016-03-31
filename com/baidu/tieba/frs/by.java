package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class by implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId bmY = BdUniqueId.gen();
    private int height = 0;
    private int bmZ = 0;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bmY;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int Rw() {
        return this.bmZ;
    }

    public void gI(int i) {
        this.bmZ = i;
    }
}
