package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes2.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId iEe = BdUniqueId.gen();
    private ScoreCardInfo iEf;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.iEf = scoreCardInfo;
    }

    public ScoreCardInfo ctU() {
        return this.iEf;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iEe;
    }
}
