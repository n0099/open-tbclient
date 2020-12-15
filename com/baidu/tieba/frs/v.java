package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class v extends BaseCardInfo {
    public static final BdUniqueId iWK = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iWK;
    }
}
