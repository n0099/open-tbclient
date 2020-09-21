package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes21.dex */
public class c implements q {
    public static BdUniqueId hxt = BdUniqueId.gen();
    private FeatureCardCompetition hxu;
    private Integer hxv;
    private Integer hxw;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hxt;
    }

    public FeatureCardCompetition cgG() {
        return this.hxu;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.hxu = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.hxv = featureCardCompetition.floor;
            this.hxw = featureCardCompetition.type;
        }
    }
}
