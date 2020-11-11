package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gCM = BdUniqueId.gen();
    public static final BdUniqueId gCN = BdUniqueId.gen();
    public bw exA;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.exA == null || this.exA.bmU() == null || this.exA.bmU().live_type != 1) ? gCM : gCN;
    }
}
