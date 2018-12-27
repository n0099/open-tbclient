package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dnt = BdUniqueId.gen();
    private ScoreCardInfo dnu;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.dnu = scoreCardInfo;
    }

    public ScoreCardInfo auC() {
        return this.dnu;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dnt;
    }
}
