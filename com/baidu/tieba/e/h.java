package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cEi = BdUniqueId.gen();
    private Integer cDY;
    private Integer cDZ;
    private FeatureCardTopic cEj;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cEi;
    }

    public FeatureCardTopic ajA() {
        return this.cEj;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.cEj = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.cDY = featureCardTopic.floor;
            this.cDZ = featureCardTopic.type;
        }
    }
}
