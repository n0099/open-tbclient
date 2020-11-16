package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes21.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId ifL = BdUniqueId.gen();
    private ScoreCardInfo ifM;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.ifM = scoreCardInfo;
    }

    public ScoreCardInfo cpr() {
        return this.ifM;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ifL;
    }
}
