package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes9.dex */
public class h implements m {
    public static BdUniqueId fQF = BdUniqueId.gen();
    private FeatureCardTopic fQG;
    private Integer fQv;
    private Integer fQw;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQF;
    }

    public FeatureCardTopic bwH() {
        return this.fQG;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.fQG = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.fQv = featureCardTopic.floor;
            this.fQw = featureCardTopic.type;
        }
    }
}
