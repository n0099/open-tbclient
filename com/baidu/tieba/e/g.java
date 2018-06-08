package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cOf = BdUniqueId.gen();
    private ScoreCardInfo cOg;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.cOg = scoreCardInfo;
    }

    public ScoreCardInfo anw() {
        return this.cOg;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOf;
    }
}
