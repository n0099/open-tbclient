package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes4.dex */
public class h implements m {
    public static BdUniqueId eNq = BdUniqueId.gen();
    private Integer eNg;
    private Integer eNh;
    private FeatureCardTopic eNr;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNq;
    }

    public FeatureCardTopic bbY() {
        return this.eNr;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.eNr = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.eNg = featureCardTopic.floor;
            this.eNh = featureCardTopic.type;
        }
    }
}
