package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes4.dex */
public class h implements m {
    public static BdUniqueId eWU = BdUniqueId.gen();
    private Integer eWK;
    private Integer eWL;
    private FeatureCardTopic eWV;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWU;
    }

    public FeatureCardTopic bcD() {
        return this.eWV;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.eWV = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.eWK = featureCardTopic.floor;
            this.eWL = featureCardTopic.type;
        }
    }
}
