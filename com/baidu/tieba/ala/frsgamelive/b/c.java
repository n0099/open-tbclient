package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fuH = BdUniqueId.gen();
    public static final BdUniqueId fuI = BdUniqueId.gen();
    public bk dEA;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return (this.dEA == null || this.dEA.aQS() == null || this.dEA.aQS().live_type != 1) ? fuH : fuI;
    }
}
