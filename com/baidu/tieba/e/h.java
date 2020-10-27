package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes22.dex */
public class h implements q {
    public static BdUniqueId hYX = BdUniqueId.gen();
    private Integer hYN;
    private Integer hYO;
    private FeatureCardTopic hYY;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hYX;
    }

    public FeatureCardTopic cno() {
        return this.hYY;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.hYY = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.hYN = featureCardTopic.floor;
            this.hYO = featureCardTopic.type;
        }
    }
}
