package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gvU = BdUniqueId.gen();
    private ScoreCardInfo gvV;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.gvV = scoreCardInfo;
    }

    public ScoreCardInfo bGx() {
        return this.gvV;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvU;
    }
}
