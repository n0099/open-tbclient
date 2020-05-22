package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gKL = BdUniqueId.gen();
    private ScoreCardInfo gKM;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.gKM = scoreCardInfo;
    }

    public ScoreCardInfo bMP() {
        return this.gKM;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gKL;
    }
}
