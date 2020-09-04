package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes16.dex */
public class c implements q {
    public static BdUniqueId hqo = BdUniqueId.gen();
    private FeatureCardCompetition hqp;
    private Integer hqq;
    private Integer hqr;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqo;
    }

    public FeatureCardCompetition cdr() {
        return this.hqp;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.hqp = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.hqq = featureCardCompetition.floor;
            this.hqr = featureCardCompetition.type;
        }
    }
}
