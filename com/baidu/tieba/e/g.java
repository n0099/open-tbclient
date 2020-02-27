package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fQo = BdUniqueId.gen();
    private ScoreCardInfo fQp;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.fQp = scoreCardInfo;
    }

    public ScoreCardInfo bwD() {
        return this.fQp;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQo;
    }
}
