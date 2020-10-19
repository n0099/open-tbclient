package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes22.dex */
public class c implements q {
    public static BdUniqueId hMo = BdUniqueId.gen();
    private FeatureCardCompetition hMp;
    private Integer hMq;
    private Integer hMr;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hMo;
    }

    public FeatureCardCompetition ckc() {
        return this.hMp;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.hMp = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.hMq = featureCardCompetition.floor;
            this.hMr = featureCardCompetition.type;
        }
    }
}
