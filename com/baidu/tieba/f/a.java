package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId iqv = BdUniqueId.gen();
    private by alu;

    public void setData(by byVar) {
        this.alu = byVar;
    }

    public by bmn() {
        return this.alu;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqv;
    }
}
