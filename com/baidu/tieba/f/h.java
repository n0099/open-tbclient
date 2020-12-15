package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes22.dex */
public class h implements q {
    public static BdUniqueId iqJ = BdUniqueId.gen();
    private Integer iqA;
    private FeatureCardTopic iqK;
    private Integer iqz;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqJ;
    }

    public FeatureCardTopic ctH() {
        return this.iqK;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.iqK = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.iqz = featureCardTopic.floor;
            this.iqA = featureCardTopic.type;
        }
    }
}
