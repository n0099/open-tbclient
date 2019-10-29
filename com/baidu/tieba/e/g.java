package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eWS = BdUniqueId.gen();
    private ScoreCardInfo eWT;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.eWT = scoreCardInfo;
    }

    public ScoreCardInfo bcC() {
        return this.eWT;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWS;
    }
}
