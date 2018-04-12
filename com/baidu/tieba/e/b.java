package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cDY = BdUniqueId.gen();
    private bd bjU;

    public void setData(bd bdVar) {
        this.bjU = bdVar;
    }

    public bd Pe() {
        return this.bjU;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cDY;
    }
}
