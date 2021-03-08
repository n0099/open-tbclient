package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gXf = BdUniqueId.gen();
    public static final BdUniqueId gXg = BdUniqueId.gen();
    public cb eLr;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return (this.eLr == null || this.eLr.bol() == null || this.eLr.bol().live_type != 1) ? gXf : gXg;
    }
}
