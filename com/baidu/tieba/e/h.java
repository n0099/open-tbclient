package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId dkE = BdUniqueId.gen();
    private FeatureCardTopic dkF;
    private Integer dku;
    private Integer dkv;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dkE;
    }

    public FeatureCardTopic atO() {
        return this.dkF;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.dkF = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.dku = featureCardTopic.floor;
            this.dkv = featureCardTopic.type;
        }
    }
}
