package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes21.dex */
public class c implements q {
    public static BdUniqueId ifB = BdUniqueId.gen();
    private FeatureCardCompetition ifC;
    private Integer ifD;
    private Integer ifE;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ifB;
    }

    public FeatureCardCompetition cpn() {
        return this.ifC;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.ifC = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.ifD = featureCardCompetition.floor;
            this.ifE = featureCardCompetition.type;
        }
    }
}
