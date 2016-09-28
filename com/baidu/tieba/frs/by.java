package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class by implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bRY = BdUniqueId.gen();
    private int bRZ;

    public int acs() {
        return this.bRZ;
    }

    public void hY(int i) {
        this.bRZ = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bRY;
    }
}
