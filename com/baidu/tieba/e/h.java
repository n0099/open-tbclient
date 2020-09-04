package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes16.dex */
public class h implements q {
    public static BdUniqueId hqA = BdUniqueId.gen();
    private FeatureCardTopic hqB;
    private Integer hqq;
    private Integer hqr;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqA;
    }

    public FeatureCardTopic cdw() {
        return this.hqB;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.hqB = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.hqq = featureCardTopic.floor;
            this.hqr = featureCardTopic.type;
        }
    }
}
