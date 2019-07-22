package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eSp = BdUniqueId.gen();
    private ScoreCardInfo eSq;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.eSq = scoreCardInfo;
    }

    public ScoreCardInfo beb() {
        return this.eSq;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSp;
    }
}
