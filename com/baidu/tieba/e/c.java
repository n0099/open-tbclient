package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes9.dex */
public class c implements o {
    public static BdUniqueId gKM = BdUniqueId.gen();
    private FeatureCardCompetition gKN;
    private Integer gKO;
    private Integer gKP;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gKM;
    }

    public FeatureCardCompetition bMN() {
        return this.gKN;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.gKN = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.gKO = featureCardCompetition.floor;
            this.gKP = featureCardCompetition.type;
        }
    }
}
