package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cOI = BdUniqueId.gen();
    private ScoreCardInfo cOJ;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.cOJ = scoreCardInfo;
    }

    public ScoreCardInfo anp() {
        return this.cOJ;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOI;
    }
}
