package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes4.dex */
public class h implements m {
    public static BdUniqueId exM = BdUniqueId.gen();
    private Integer exC;
    private Integer exD;
    private FeatureCardTopic exN;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exM;
    }

    public FeatureCardTopic aUQ() {
        return this.exN;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.exN = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.exC = featureCardTopic.floor;
            this.exD = featureCardTopic.type;
        }
    }
}
