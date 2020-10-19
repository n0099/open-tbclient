package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes22.dex */
public class h implements q {
    public static BdUniqueId hMA = BdUniqueId.gen();
    private FeatureCardTopic hMB;
    private Integer hMq;
    private Integer hMr;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hMA;
    }

    public FeatureCardTopic ckh() {
        return this.hMB;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.hMB = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.hMq = featureCardTopic.floor;
            this.hMr = featureCardTopic.type;
        }
    }
}
