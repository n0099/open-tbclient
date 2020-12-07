package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
/* loaded from: classes21.dex */
public class e extends k {
    public static final BdUniqueId imO = BdUniqueId.gen();

    public e(by byVar) {
        this.eCR = byVar;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return imO;
    }

    public static boolean ad(by byVar) {
        return byVar != null && byVar.getType() == by.eJh;
    }

    @Override // com.baidu.tieba.card.data.k, com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public by bmn() {
        return this.eCR;
    }
}
