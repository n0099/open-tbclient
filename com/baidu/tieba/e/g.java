package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cUw = BdUniqueId.gen();
    private ScoreCardInfo cUx;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.cUx = scoreCardInfo;
    }

    public ScoreCardInfo apd() {
        return this.cUx;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUw;
    }
}
