package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId ifF = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b ifG;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.ifG = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b cpo() {
        return this.ifG;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ifF;
    }
}
