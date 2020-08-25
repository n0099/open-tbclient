package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes16.dex */
public class f implements q {
    public static final BdUniqueId hqq = BdUniqueId.gen();
    private Integer hqk;
    private Integer hql;
    private FeatureCardGame hqr;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqq;
    }

    public FeatureCardGame cdt() {
        return this.hqr;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.hqr = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.hqk = featureCardGame.floor;
            this.hql = featureCardGame.type;
        }
    }
}
