package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId doj = BdUniqueId.gen();
    private Integer dnY;
    private Integer dnZ;
    private FeatureCardTopic dok;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return doj;
    }

    public FeatureCardTopic avb() {
        return this.dok;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.dok = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.dnY = featureCardTopic.floor;
            this.dnZ = featureCardTopic.type;
        }
    }
}
