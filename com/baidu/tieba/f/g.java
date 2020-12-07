package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes22.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId iqF = BdUniqueId.gen();
    private ScoreCardInfo iqG;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.iqG = scoreCardInfo;
    }

    public ScoreCardInfo ctF() {
        return this.iqG;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqF;
    }
}
