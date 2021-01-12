package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes2.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId iyu = BdUniqueId.gen();
    private ScoreCardInfo iyv;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.iyv = scoreCardInfo;
    }

    public ScoreCardInfo csI() {
        return this.iyv;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iyu;
    }
}
