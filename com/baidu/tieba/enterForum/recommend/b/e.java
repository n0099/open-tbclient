package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId iGA = BdUniqueId.gen();
    public int iGB;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iGA;
    }
}
