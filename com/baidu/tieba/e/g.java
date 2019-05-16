package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eNo = BdUniqueId.gen();
    private ScoreCardInfo eNp;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.eNp = scoreCardInfo;
    }

    public ScoreCardInfo bbX() {
        return this.eNp;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNo;
    }
}
