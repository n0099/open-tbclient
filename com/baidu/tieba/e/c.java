package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cOv = BdUniqueId.gen();
    private FeatureCardCompetition cOw;
    private Integer cOx;
    private Integer cOy;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOv;
    }

    public FeatureCardCompetition ann() {
        return this.cOw;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.cOw = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.cOx = featureCardCompetition.floor;
            this.cOy = featureCardCompetition.type;
        }
    }
}
