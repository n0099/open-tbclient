package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes16.dex */
public class c implements q {
    public static BdUniqueId hqi = BdUniqueId.gen();
    private FeatureCardCompetition hqj;
    private Integer hqk;
    private Integer hql;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqi;
    }

    public FeatureCardCompetition cdq() {
        return this.hqj;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.hqj = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.hqk = featureCardCompetition.floor;
            this.hql = featureCardCompetition.type;
        }
    }
}
