package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes16.dex */
public class c implements q {
    public static BdUniqueId hdo = BdUniqueId.gen();
    private FeatureCardCompetition hdp;
    private Integer hdq;
    private Integer hdr;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hdo;
    }

    public FeatureCardCompetition bTe() {
        return this.hdp;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.hdp = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.hdq = featureCardCompetition.floor;
            this.hdr = featureCardCompetition.type;
        }
    }
}
