package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes16.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hdy = BdUniqueId.gen();
    private ScoreCardInfo hdz;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.hdz = scoreCardInfo;
    }

    public ScoreCardInfo bTi() {
        return this.hdz;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hdy;
    }
}
