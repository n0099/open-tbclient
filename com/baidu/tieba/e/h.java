package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cOh = BdUniqueId.gen();
    private Integer cNX;
    private Integer cNY;
    private FeatureCardTopic cOi;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOh;
    }

    public FeatureCardTopic anx() {
        return this.cOi;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.cOi = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.cNX = featureCardTopic.floor;
            this.cNY = featureCardTopic.type;
        }
    }
}
