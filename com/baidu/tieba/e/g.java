package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eNp = BdUniqueId.gen();
    private ScoreCardInfo eNq;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.eNq = scoreCardInfo;
    }

    public ScoreCardInfo bca() {
        return this.eNq;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNp;
    }
}
