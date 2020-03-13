package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fQD = BdUniqueId.gen();
    private ScoreCardInfo fQE;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.fQE = scoreCardInfo;
    }

    public ScoreCardInfo bwG() {
        return this.fQE;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQD;
    }
}
