package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId dnW = BdUniqueId.gen();
    private FeatureCardCompetition dnX;
    private Integer dnY;
    private Integer dnZ;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dnW;
    }

    public FeatureCardCompetition auW() {
        return this.dnX;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.dnX = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.dnY = featureCardCompetition.floor;
            this.dnZ = featureCardCompetition.type;
        }
    }
}
