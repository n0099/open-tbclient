package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iLy = BdUniqueId.gen();
    private int iLz;

    public int czD() {
        return this.iLz;
    }

    public void zu(int i) {
        this.iLz = i;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iLy;
    }
}
