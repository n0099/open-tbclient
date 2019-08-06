package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eSw = BdUniqueId.gen();
    private ScoreCardInfo eSx;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.eSx = scoreCardInfo;
    }

    public ScoreCardInfo bed() {
        return this.eSx;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSw;
    }
}
