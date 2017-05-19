package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ba implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bPY = BdUniqueId.gen();
    private int bPZ;

    public int ZX() {
        return this.bPZ;
    }

    public void hP(int i) {
        this.bPZ = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bPY;
    }
}
