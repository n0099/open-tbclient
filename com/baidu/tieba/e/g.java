package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ddU = BdUniqueId.gen();
    private ScoreCardInfo ddV;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.ddV = scoreCardInfo;
    }

    public ScoreCardInfo asb() {
        return this.ddV;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ddU;
    }
}
