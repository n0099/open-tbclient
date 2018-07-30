package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cOy = BdUniqueId.gen();
    private Integer cOA;
    private Integer cOB;
    private FeatureCardCompetition cOz;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOy;
    }

    public FeatureCardCompetition anl() {
        return this.cOz;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.cOz = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.cOA = featureCardCompetition.floor;
            this.cOB = featureCardCompetition.type;
        }
    }
}
