package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cEl = BdUniqueId.gen();
    private Integer cEb;
    private Integer cEc;
    private FeatureCardTopic cEm;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cEl;
    }

    public FeatureCardTopic ajA() {
        return this.cEm;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.cEm = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.cEb = featureCardTopic.floor;
            this.cEc = featureCardTopic.type;
        }
    }
}
