package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes16.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hqs = BdUniqueId.gen();
    private ScoreCardInfo hqt;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.hqt = scoreCardInfo;
    }

    public ScoreCardInfo cdu() {
        return this.hqt;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqs;
    }
}
