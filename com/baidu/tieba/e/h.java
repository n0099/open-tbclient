package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes4.dex */
public class h implements m {
    public static BdUniqueId eSr = BdUniqueId.gen();
    private Integer eSh;
    private Integer eSi;
    private FeatureCardTopic eSs;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSr;
    }

    public FeatureCardTopic bec() {
        return this.eSs;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.eSs = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.eSh = featureCardTopic.floor;
            this.eSi = featureCardTopic.type;
        }
    }
}
