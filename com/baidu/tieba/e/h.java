package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes9.dex */
public class h implements m {
    public static BdUniqueId fRo = BdUniqueId.gen();
    private Integer fRe;
    private Integer fRf;
    private FeatureCardTopic fRp;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fRo;
    }

    public FeatureCardTopic bwM() {
        return this.fRp;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.fRp = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.fRe = featureCardTopic.floor;
            this.fRf = featureCardTopic.type;
        }
    }
}
