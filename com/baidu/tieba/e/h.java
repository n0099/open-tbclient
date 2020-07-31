package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes16.dex */
public class h implements q {
    public static BdUniqueId hdA = BdUniqueId.gen();
    private FeatureCardTopic hdB;
    private Integer hdq;
    private Integer hdr;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hdA;
    }

    public FeatureCardTopic bTj() {
        return this.hdB;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.hdB = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.hdq = featureCardTopic.floor;
            this.hdr = featureCardTopic.type;
        }
    }
}
