package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dkC = BdUniqueId.gen();
    private ScoreCardInfo dkD;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.dkD = scoreCardInfo;
    }

    public ScoreCardInfo atN() {
        return this.dkD;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dkC;
    }
}
