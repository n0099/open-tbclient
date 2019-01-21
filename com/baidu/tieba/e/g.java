package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId doh = BdUniqueId.gen();
    private ScoreCardInfo doi;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.doi = scoreCardInfo;
    }

    public ScoreCardInfo ava() {
        return this.doi;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return doh;
    }
}
