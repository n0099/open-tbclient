package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes22.dex */
public class c implements q {
    public static BdUniqueId iqv = BdUniqueId.gen();
    private FeatureCardCompetition iqw;
    private Integer iqx;
    private Integer iqy;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqv;
    }

    public FeatureCardCompetition ctB() {
        return this.iqw;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.iqw = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.iqx = featureCardCompetition.floor;
            this.iqy = featureCardCompetition.type;
        }
    }
}
