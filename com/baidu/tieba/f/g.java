package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes22.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId iqH = BdUniqueId.gen();
    private ScoreCardInfo iqI;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.iqI = scoreCardInfo;
    }

    public ScoreCardInfo ctG() {
        return this.iqI;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqH;
    }
}
