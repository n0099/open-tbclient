package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exL = BdUniqueId.gen();
    private ScoreCardInfo exM;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.exM = scoreCardInfo;
    }

    public ScoreCardInfo aUP() {
        return this.exM;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exL;
    }
}
