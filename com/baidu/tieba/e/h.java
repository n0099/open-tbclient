package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes4.dex */
public class h implements m {
    public static BdUniqueId exN = BdUniqueId.gen();
    private Integer exD;
    private Integer exE;
    private FeatureCardTopic exO;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exN;
    }

    public FeatureCardTopic aUQ() {
        return this.exO;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.exO = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.exD = featureCardTopic.floor;
            this.exE = featureCardTopic.type;
        }
    }
}
