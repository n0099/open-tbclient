package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dcO = BdUniqueId.gen();
    private ScoreCardInfo dcP;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.dcP = scoreCardInfo;
    }

    public ScoreCardInfo asC() {
        return this.dcP;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dcO;
    }
}
