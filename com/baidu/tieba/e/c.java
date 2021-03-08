package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes2.dex */
public class c implements n {
    public static BdUniqueId iFR = BdUniqueId.gen();
    private FeatureCardCompetition iFS;
    private Integer iFT;
    private Integer iFU;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iFR;
    }

    public FeatureCardCompetition cud() {
        return this.iFS;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.iFS = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.iFT = featureCardCompetition.floor;
            this.iFU = featureCardCompetition.type;
        }
    }
}
