package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes6.dex */
public class h implements m {
    public static BdUniqueId fKM = BdUniqueId.gen();
    private Integer fKC;
    private Integer fKD;
    private FeatureCardTopic fKN;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fKM;
    }

    public FeatureCardTopic btY() {
        return this.fKN;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.fKN = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.fKC = featureCardTopic.floor;
            this.fKD = featureCardTopic.type;
        }
    }
}
