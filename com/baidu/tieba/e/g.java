package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes22.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ieW = BdUniqueId.gen();
    private ScoreCardInfo ieX;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.ieX = scoreCardInfo;
    }

    public ScoreCardInfo cpO() {
        return this.ieX;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ieW;
    }
}
