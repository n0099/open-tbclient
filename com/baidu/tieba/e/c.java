package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cNV = BdUniqueId.gen();
    private FeatureCardCompetition cNW;
    private Integer cNX;
    private Integer cNY;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cNV;
    }

    public FeatureCardCompetition ans() {
        return this.cNW;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.cNW = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.cNX = featureCardCompetition.floor;
            this.cNY = featureCardCompetition.type;
        }
    }
}
