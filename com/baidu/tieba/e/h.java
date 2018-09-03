package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cOH = BdUniqueId.gen();
    private FeatureCardTopic cOI;
    private Integer cOx;
    private Integer cOy;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOH;
    }

    public FeatureCardTopic ans() {
        return this.cOI;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.cOI = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.cOx = featureCardTopic.floor;
            this.cOy = featureCardTopic.type;
        }
    }
}
