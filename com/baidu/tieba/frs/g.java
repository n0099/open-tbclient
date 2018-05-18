package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cXZ = BdUniqueId.gen();
    private int height = 0;
    private int cYa = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cXZ;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int apb() {
        return this.cYa;
    }

    public void jY(int i) {
        this.cYa = i;
    }
}
