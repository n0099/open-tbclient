package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bc implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId cdX = BdUniqueId.gen();
    private int cdY;

    public int aeQ() {
        return this.cdY;
    }

    public void iz(int i) {
        this.cdY = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cdX;
    }
}
