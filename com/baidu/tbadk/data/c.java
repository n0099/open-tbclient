package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ayb = BdUniqueId.gen();
    private int size;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ayb;
    }

    public void setSize(int i) {
        this.size = i;
    }
}
