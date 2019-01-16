package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId doi = BdUniqueId.gen();
    private Integer dnX;
    private Integer dnY;
    private FeatureCardTopic doj;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return doi;
    }

    public FeatureCardTopic avb() {
        return this.doj;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.doj = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.dnX = featureCardTopic.floor;
            this.dnY = featureCardTopic.type;
        }
    }
}
