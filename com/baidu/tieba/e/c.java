package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId dnV = BdUniqueId.gen();
    private FeatureCardCompetition dnW;
    private Integer dnX;
    private Integer dnY;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dnV;
    }

    public FeatureCardCompetition auW() {
        return this.dnW;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.dnW = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.dnX = featureCardCompetition.floor;
            this.dnY = featureCardCompetition.type;
        }
    }
}
