package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cLZ = BdUniqueId.gen();
    private ScoreCardInfo cMa;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.cMa = scoreCardInfo;
    }

    public ScoreCardInfo amQ() {
        return this.cMa;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cLZ;
    }
}
