package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes22.dex */
public class c implements q {
    public static BdUniqueId ieM = BdUniqueId.gen();
    private FeatureCardCompetition ieN;
    private Integer ieO;
    private Integer ieP;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ieM;
    }

    public FeatureCardCompetition cpK() {
        return this.ieN;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.ieN = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.ieO = featureCardCompetition.floor;
            this.ieP = featureCardCompetition.type;
        }
    }
}
