package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class a extends BaseCardInfo {
    public static final BdUniqueId ifz = BdUniqueId.gen();
    private bx akt;

    public void setData(bx bxVar) {
        this.akt = bxVar;
    }

    public bx bjd() {
        return this.akt;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ifz;
    }
}
