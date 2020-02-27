package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes9.dex */
public class h implements m {
    public static BdUniqueId fQq = BdUniqueId.gen();
    private Integer fQg;
    private Integer fQh;
    private FeatureCardTopic fQr;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQq;
    }

    public FeatureCardTopic bwE() {
        return this.fQr;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.fQr = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.fQg = featureCardTopic.floor;
            this.fQh = featureCardTopic.type;
        }
    }
}
