package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes9.dex */
public class h implements o {
    public static BdUniqueId gKN = BdUniqueId.gen();
    private Integer gKD;
    private Integer gKE;
    private FeatureCardTopic gKO;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gKN;
    }

    public FeatureCardTopic bMQ() {
        return this.gKO;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.gKO = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.gKD = featureCardTopic.floor;
            this.gKE = featureCardTopic.type;
        }
    }
}
