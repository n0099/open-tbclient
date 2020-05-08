package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.ScoreCardInfo;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gwa = BdUniqueId.gen();
    private ScoreCardInfo gwb;

    public void a(ScoreCardInfo scoreCardInfo) {
        this.gwb = scoreCardInfo;
    }

    public ScoreCardInfo bGv() {
        return this.gwb;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gwa;
    }
}
