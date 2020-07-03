package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fFR = BdUniqueId.gen();
    public static final BdUniqueId fFS = BdUniqueId.gen();
    public bu dLi;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.dLi == null || this.dLi.aSJ() == null || this.dLi.aSJ().live_type != 1) ? fFR : fFS;
    }
}
