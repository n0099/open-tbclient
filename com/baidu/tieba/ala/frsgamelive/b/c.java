package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gVi = BdUniqueId.gen();
    public static final BdUniqueId gVj = BdUniqueId.gen();
    public cb eJQ;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return (this.eJQ == null || this.eJQ.boj() == null || this.eJQ.boj().live_type != 1) ? gVi : gVj;
    }
}
