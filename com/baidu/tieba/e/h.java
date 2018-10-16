package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId dcQ = BdUniqueId.gen();
    private Integer dcG;
    private Integer dcH;
    private FeatureCardTopic dcR;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dcQ;
    }

    public FeatureCardTopic asC() {
        return this.dcR;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.dcR = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.dcG = featureCardTopic.floor;
            this.dcH = featureCardTopic.type;
        }
    }
}
