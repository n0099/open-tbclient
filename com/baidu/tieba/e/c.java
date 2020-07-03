package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes9.dex */
public class c implements q {
    public static BdUniqueId gXJ = BdUniqueId.gen();
    private FeatureCardCompetition gXK;
    private Integer gXL;
    private Integer gXM;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gXJ;
    }

    public FeatureCardCompetition bPS() {
        return this.gXK;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.gXK = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.gXL = featureCardCompetition.floor;
            this.gXM = featureCardCompetition.type;
        }
    }
}
