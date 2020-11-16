package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId ioa = BdUniqueId.gen();
    public int iob;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ioa;
    }
}
