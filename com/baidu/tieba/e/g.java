package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes2.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId iEs = BdUniqueId.gen();
    private ScoreCardInfo iEt;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.iEt = scoreCardInfo;
    }

    public ScoreCardInfo cub() {
        return this.iEt;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iEs;
    }
}
