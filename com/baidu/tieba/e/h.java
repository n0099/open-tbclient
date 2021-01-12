package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes2.dex */
public class h implements n {
    public static BdUniqueId iyw = BdUniqueId.gen();
    private Integer iym;
    private Integer iyn;
    private FeatureCardTopic iyx;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iyw;
    }

    public FeatureCardTopic csJ() {
        return this.iyx;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.iyx = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.iym = featureCardTopic.floor;
            this.iyn = featureCardTopic.type;
        }
    }
}
