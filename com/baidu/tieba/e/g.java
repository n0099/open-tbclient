package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes7.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fNT = BdUniqueId.gen();
    private ScoreCardInfo fNU;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.fNU = scoreCardInfo;
    }

    public ScoreCardInfo buZ() {
        return this.fNU;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNT;
    }
}
