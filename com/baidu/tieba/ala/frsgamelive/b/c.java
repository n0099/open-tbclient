package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gaC = BdUniqueId.gen();
    public static final BdUniqueId gaD = BdUniqueId.gen();
    public bw dXg;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.dXg == null || this.dXg.bfS() == null || this.dXg.bfS().live_type != 1) ? gaC : gaD;
    }
}
