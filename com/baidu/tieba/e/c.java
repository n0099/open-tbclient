package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cDZ = BdUniqueId.gen();
    private FeatureCardCompetition cEa;
    private Integer cEb;
    private Integer cEc;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cDZ;
    }

    public FeatureCardCompetition ajv() {
        return this.cEa;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.cEa = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.cEb = featureCardCompetition.floor;
            this.cEc = featureCardCompetition.type;
        }
    }
}
