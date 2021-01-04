package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes2.dex */
public class h implements n {
    public static BdUniqueId iDd = BdUniqueId.gen();
    private Integer iCT;
    private Integer iCU;
    private FeatureCardTopic iDe;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iDd;
    }

    public FeatureCardTopic cwA() {
        return this.iDe;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.iDe = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.iCT = featureCardTopic.floor;
            this.iCU = featureCardTopic.type;
        }
    }
}
