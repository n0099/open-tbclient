package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes9.dex */
public class c implements o {
    public static BdUniqueId gKB = BdUniqueId.gen();
    private FeatureCardCompetition gKC;
    private Integer gKD;
    private Integer gKE;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gKB;
    }

    public FeatureCardCompetition bML() {
        return this.gKC;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.gKC = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.gKD = featureCardCompetition.floor;
            this.gKE = featureCardCompetition.type;
        }
    }
}
