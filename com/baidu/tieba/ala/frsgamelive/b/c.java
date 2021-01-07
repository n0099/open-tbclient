package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gXe = BdUniqueId.gen();
    public static final BdUniqueId gXf = BdUniqueId.gen();
    public bz eMv;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return (this.eMv == null || this.eMv.brK() == null || this.eMv.brK().live_type != 1) ? gXe : gXf;
    }
}
