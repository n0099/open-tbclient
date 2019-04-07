package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exz = BdUniqueId.gen();
    private bg bTn;

    public void setData(bg bgVar) {
        this.bTn = bgVar;
    }

    public bg WO() {
        return this.bTn;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exz;
    }
}
