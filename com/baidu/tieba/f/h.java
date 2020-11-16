package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes21.dex */
public class h implements q {
    public static BdUniqueId ifN = BdUniqueId.gen();
    private Integer ifD;
    private Integer ifE;
    private FeatureCardTopic ifO;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ifN;
    }

    public FeatureCardTopic cps() {
        return this.ifO;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.ifO = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.ifD = featureCardTopic.floor;
            this.ifE = featureCardTopic.type;
        }
    }
}
