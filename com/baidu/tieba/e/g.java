package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes21.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hxD = BdUniqueId.gen();
    private ScoreCardInfo hxE;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.hxE = scoreCardInfo;
    }

    public ScoreCardInfo cgK() {
        return this.hxE;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hxD;
    }
}
