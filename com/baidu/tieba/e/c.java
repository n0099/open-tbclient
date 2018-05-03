package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cDW = BdUniqueId.gen();
    private FeatureCardCompetition cDX;
    private Integer cDY;
    private Integer cDZ;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cDW;
    }

    public FeatureCardCompetition ajv() {
        return this.cDX;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.cDX = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.cDY = featureCardCompetition.floor;
            this.cDZ = featureCardCompetition.type;
        }
    }
}
