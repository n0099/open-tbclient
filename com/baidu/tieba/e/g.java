package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes22.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hYV = BdUniqueId.gen();
    private ScoreCardInfo hYW;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.hYW = scoreCardInfo;
    }

    public ScoreCardInfo cnn() {
        return this.hYW;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hYV;
    }
}
