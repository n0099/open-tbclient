package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eWb = BdUniqueId.gen();
    private ScoreCardInfo eWc;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.eWc = scoreCardInfo;
    }

    public ScoreCardInfo bcA() {
        return this.eWc;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWb;
    }
}
