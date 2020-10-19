package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes22.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hMy = BdUniqueId.gen();
    private ScoreCardInfo hMz;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.hMz = scoreCardInfo;
    }

    public ScoreCardInfo ckg() {
        return this.hMz;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hMy;
    }
}
