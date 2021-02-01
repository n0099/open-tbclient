package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes2.dex */
public class c implements n {
    public static BdUniqueId iDU = BdUniqueId.gen();
    private FeatureCardCompetition iDV;
    private Integer iDW;
    private Integer iDX;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iDU;
    }

    public FeatureCardCompetition ctQ() {
        return this.iDV;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.iDV = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.iDW = featureCardCompetition.floor;
            this.iDX = featureCardCompetition.type;
        }
    }
}
