package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cOK = BdUniqueId.gen();
    private Integer cOA;
    private Integer cOB;
    private FeatureCardTopic cOL;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOK;
    }

    public FeatureCardTopic anq() {
        return this.cOL;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.cOL = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.cOA = featureCardTopic.floor;
            this.cOB = featureCardTopic.type;
        }
    }
}
