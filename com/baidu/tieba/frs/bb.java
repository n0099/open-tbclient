package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bb implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bVP = BdUniqueId.gen();
    private int bVQ;

    public int aaZ() {
        return this.bVQ;
    }

    public void in(int i) {
        this.bVQ = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bVP;
    }
}
