package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes22.dex */
public class c implements q {
    public static BdUniqueId hYL = BdUniqueId.gen();
    private FeatureCardCompetition hYM;
    private Integer hYN;
    private Integer hYO;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hYL;
    }

    public FeatureCardCompetition cnj() {
        return this.hYM;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.hYM = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.hYN = featureCardCompetition.floor;
            this.hYO = featureCardCompetition.type;
        }
    }
}
