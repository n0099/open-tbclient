package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cOF = BdUniqueId.gen();
    private ScoreCardInfo cOG;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.cOG = scoreCardInfo;
    }

    public ScoreCardInfo anr() {
        return this.cOG;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOF;
    }
}
