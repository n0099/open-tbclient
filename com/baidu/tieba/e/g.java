package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes2.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId iGb = BdUniqueId.gen();
    private ScoreCardInfo iGc;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.iGc = scoreCardInfo;
    }

    public ScoreCardInfo cuh() {
        return this.iGc;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iGb;
    }
}
