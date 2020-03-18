package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fRm = BdUniqueId.gen();
    private ScoreCardInfo fRn;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.fRn = scoreCardInfo;
    }

    public ScoreCardInfo bwL() {
        return this.fRn;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fRm;
    }
}
