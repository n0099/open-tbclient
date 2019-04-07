package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exK = BdUniqueId.gen();
    private ScoreCardInfo exL;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.exL = scoreCardInfo;
    }

    public ScoreCardInfo aUP() {
        return this.exL;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exK;
    }
}
