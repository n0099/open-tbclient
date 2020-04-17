package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes9.dex */
public class h implements m {
    public static BdUniqueId gvW = BdUniqueId.gen();
    private Integer gvM;
    private Integer gvN;
    private FeatureCardTopic gvX;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvW;
    }

    public FeatureCardTopic bGy() {
        return this.gvX;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.gvX = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.gvM = featureCardTopic.floor;
            this.gvN = featureCardTopic.type;
        }
    }
}
