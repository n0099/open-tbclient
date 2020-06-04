package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gKW = BdUniqueId.gen();
    private ScoreCardInfo gKX;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.gKX = scoreCardInfo;
    }

    public ScoreCardInfo bMR() {
        return this.gKX;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gKW;
    }
}
