package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes4.dex */
public class h implements m {
    public static BdUniqueId eSy = BdUniqueId.gen();
    private Integer eSo;
    private Integer eSp;
    private FeatureCardTopic eSz;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSy;
    }

    public FeatureCardTopic bee() {
        return this.eSz;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.eSz = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.eSo = featureCardTopic.floor;
            this.eSp = featureCardTopic.type;
        }
    }
}
