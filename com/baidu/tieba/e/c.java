package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes2.dex */
public class c implements n {
    public static BdUniqueId iyk = BdUniqueId.gen();
    private FeatureCardCompetition iyl;
    private Integer iym;
    private Integer iyn;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iyk;
    }

    public FeatureCardCompetition csE() {
        return this.iyl;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.iyl = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.iym = featureCardCompetition.floor;
            this.iyn = featureCardCompetition.type;
        }
    }
}
