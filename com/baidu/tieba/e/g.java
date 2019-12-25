package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes6.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fKK = BdUniqueId.gen();
    private ScoreCardInfo fKL;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.fKL = scoreCardInfo;
    }

    public ScoreCardInfo btX() {
        return this.fKL;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fKK;
    }
}
