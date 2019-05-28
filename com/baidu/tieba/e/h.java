package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes4.dex */
public class h implements m {
    public static BdUniqueId eNr = BdUniqueId.gen();
    private Integer eNh;
    private Integer eNi;
    private FeatureCardTopic eNs;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNr;
    }

    public FeatureCardTopic bcb() {
        return this.eNs;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.eNs = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.eNh = featureCardTopic.floor;
            this.eNi = featureCardTopic.type;
        }
    }
}
