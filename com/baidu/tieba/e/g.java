package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dog = BdUniqueId.gen();
    private ScoreCardInfo doh;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.doh = scoreCardInfo;
    }

    public ScoreCardInfo ava() {
        return this.doh;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dog;
    }
}
