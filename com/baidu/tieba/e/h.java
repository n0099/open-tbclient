package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes2.dex */
public class h implements n {
    public static BdUniqueId iGd = BdUniqueId.gen();
    private Integer iFT;
    private Integer iFU;
    private FeatureCardTopic iGe;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iGd;
    }

    public FeatureCardTopic cui() {
        return this.iGe;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.iGe = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.iFT = featureCardTopic.floor;
            this.iFU = featureCardTopic.type;
        }
    }
}
