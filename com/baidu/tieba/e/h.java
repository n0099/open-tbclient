package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes7.dex */
public class h implements m {
    public static BdUniqueId fNV = BdUniqueId.gen();
    private Integer fNL;
    private Integer fNM;
    private FeatureCardTopic fNW;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNV;
    }

    public FeatureCardTopic bva() {
        return this.fNW;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.fNW = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.fNL = featureCardTopic.floor;
            this.fNM = featureCardTopic.type;
        }
    }
}
