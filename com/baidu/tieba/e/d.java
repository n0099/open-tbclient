package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iFV = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b iFW;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.iFW = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b cue() {
        return this.iFW;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iFV;
    }
}
