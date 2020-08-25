package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes16.dex */
public class h implements q {
    public static BdUniqueId hqu = BdUniqueId.gen();
    private Integer hqk;
    private Integer hql;
    private FeatureCardTopic hqv;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqu;
    }

    public FeatureCardTopic cdv() {
        return this.hqv;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.hqv = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.hqk = featureCardTopic.floor;
            this.hql = featureCardTopic.type;
        }
    }
}
