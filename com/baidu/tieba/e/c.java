package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cFf = BdUniqueId.gen();
    private FeatureCardCompetition cFg;
    private Integer cFh;
    private Integer cFi;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cFf;
    }

    public FeatureCardCompetition ajv() {
        return this.cFg;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.cFg = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.cFh = featureCardCompetition.floor;
            this.cFi = featureCardCompetition.type;
        }
    }
}
