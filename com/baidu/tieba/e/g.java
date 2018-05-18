package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cFp = BdUniqueId.gen();
    private ScoreCardInfo cFq;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.cFq = scoreCardInfo;
    }

    public ScoreCardInfo ajz() {
        return this.cFq;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cFp;
    }
}
