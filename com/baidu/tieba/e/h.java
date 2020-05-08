package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes9.dex */
public class h implements m {
    public static BdUniqueId gwc = BdUniqueId.gen();
    private Integer gvS;
    private Integer gvT;
    private FeatureCardTopic gwd;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gwc;
    }

    public FeatureCardTopic bGw() {
        return this.gwd;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.gwd = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.gvS = featureCardTopic.floor;
            this.gvT = featureCardTopic.type;
        }
    }
}
