package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gSy = BdUniqueId.gen();
    public static final BdUniqueId gSz = BdUniqueId.gen();
    public bz eHK;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return (this.eHK == null || this.eHK.bnQ() == null || this.eHK.bnQ().live_type != 1) ? gSy : gSz;
    }
}
