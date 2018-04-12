package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cEj = BdUniqueId.gen();
    private ScoreCardInfo cEk;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.cEk = scoreCardInfo;
    }

    public ScoreCardInfo ajz() {
        return this.cEk;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cEj;
    }
}
