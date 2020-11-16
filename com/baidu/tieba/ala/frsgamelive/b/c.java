package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gCt = BdUniqueId.gen();
    public static final BdUniqueId gCu = BdUniqueId.gen();
    public bx evQ;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return (this.evQ == null || this.evQ.blW() == null || this.evQ.blW().live_type != 1) ? gCt : gCu;
    }
}
