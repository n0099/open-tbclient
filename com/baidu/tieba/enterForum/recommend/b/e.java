package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ihn = BdUniqueId.gen();
    public int iho;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ihn;
    }
}
