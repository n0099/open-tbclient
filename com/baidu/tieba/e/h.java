package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cFr = BdUniqueId.gen();
    private Integer cFh;
    private Integer cFi;
    private FeatureCardTopic cFs;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cFr;
    }

    public FeatureCardTopic ajA() {
        return this.cFs;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.cFs = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.cFh = featureCardTopic.floor;
            this.cFi = featureCardTopic.type;
        }
    }
}
