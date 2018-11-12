package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId ddW = BdUniqueId.gen();
    private Integer ddM;
    private Integer ddN;
    private FeatureCardTopic ddX;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ddW;
    }

    public FeatureCardTopic asc() {
        return this.ddX;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.ddX = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.ddM = featureCardTopic.floor;
            this.ddN = featureCardTopic.type;
        }
    }
}
