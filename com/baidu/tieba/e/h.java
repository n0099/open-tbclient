package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes4.dex */
public class h implements m {
    public static BdUniqueId eWd = BdUniqueId.gen();
    private Integer eVT;
    private Integer eVU;
    private FeatureCardTopic eWe;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWd;
    }

    public FeatureCardTopic bcB() {
        return this.eWe;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.eWe = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.eVT = featureCardTopic.floor;
            this.eVU = featureCardTopic.type;
        }
    }
}
