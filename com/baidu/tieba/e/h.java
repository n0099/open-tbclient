package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes4.dex */
public class h implements m {
    public static BdUniqueId eUf = BdUniqueId.gen();
    private Integer eTV;
    private Integer eTW;
    private FeatureCardTopic eUg;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eUf;
    }

    public FeatureCardTopic beI() {
        return this.eUg;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.eUg = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.eTV = featureCardTopic.floor;
            this.eTW = featureCardTopic.type;
        }
    }
}
