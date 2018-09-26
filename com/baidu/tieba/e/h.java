package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cUy = BdUniqueId.gen();
    private Integer cUo;
    private Integer cUp;
    private FeatureCardTopic cUz;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUy;
    }

    public FeatureCardTopic ape() {
        return this.cUz;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.cUz = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.cUo = featureCardTopic.floor;
            this.cUp = featureCardTopic.type;
        }
    }
}
