package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes22.dex */
public class c implements q {
    public static BdUniqueId iqx = BdUniqueId.gen();
    private Integer iqA;
    private FeatureCardCompetition iqy;
    private Integer iqz;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqx;
    }

    public FeatureCardCompetition ctC() {
        return this.iqy;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.iqy = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.iqz = featureCardCompetition.floor;
            this.iqA = featureCardCompetition.type;
        }
    }
}
