package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes2.dex */
public class c implements n {
    public static BdUniqueId iCR = BdUniqueId.gen();
    private FeatureCardCompetition iCS;
    private Integer iCT;
    private Integer iCU;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iCR;
    }

    public FeatureCardCompetition cww() {
        return this.iCS;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.iCS = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.iCT = featureCardCompetition.floor;
            this.iCU = featureCardCompetition.type;
        }
    }
}
