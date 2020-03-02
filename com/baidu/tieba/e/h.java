package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes9.dex */
public class h implements m {
    public static BdUniqueId fQs = BdUniqueId.gen();
    private Integer fQi;
    private Integer fQj;
    private FeatureCardTopic fQt;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQs;
    }

    public FeatureCardTopic bwG() {
        return this.fQt;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.fQt = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.fQi = featureCardTopic.floor;
            this.fQj = featureCardTopic.type;
        }
    }
}
