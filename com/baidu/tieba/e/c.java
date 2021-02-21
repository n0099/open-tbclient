package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes2.dex */
public class c implements n {
    public static BdUniqueId iEi = BdUniqueId.gen();
    private FeatureCardCompetition iEj;
    private Integer iEk;
    private Integer iEl;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iEi;
    }

    public FeatureCardCompetition ctX() {
        return this.iEj;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.iEj = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.iEk = featureCardCompetition.floor;
            this.iEl = featureCardCompetition.type;
        }
    }
}
