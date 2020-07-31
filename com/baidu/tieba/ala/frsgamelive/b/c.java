package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fLm = BdUniqueId.gen();
    public static final BdUniqueId fLn = BdUniqueId.gen();
    public bv dLK;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.dLK == null || this.dLK.aWF() == null || this.dLK.aWF().live_type != 1) ? fLm : fLn;
    }
}
