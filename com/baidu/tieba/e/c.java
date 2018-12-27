package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId dni = BdUniqueId.gen();
    private FeatureCardCompetition dnj;
    private Integer dnk;
    private Integer dnl;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dni;
    }

    public FeatureCardCompetition auy() {
        return this.dnj;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.dnj = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.dnk = featureCardCompetition.floor;
            this.dnl = featureCardCompetition.type;
        }
    }
}
