package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aAm = BdUniqueId.gen();
    private int size;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAm;
    }

    public void setSize(int i) {
        this.size = i;
    }
}
