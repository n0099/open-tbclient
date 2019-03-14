package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes4.dex */
public class h implements m {
    public static BdUniqueId eyb = BdUniqueId.gen();
    private Integer exR;
    private Integer exS;
    private FeatureCardTopic eyc;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eyb;
    }

    public FeatureCardTopic aUS() {
        return this.eyc;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.eyc = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.exR = featureCardTopic.floor;
            this.exS = featureCardTopic.type;
        }
    }
}
