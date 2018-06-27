package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cMb = BdUniqueId.gen();
    private Integer cLR;
    private Integer cLS;
    private FeatureCardTopic cMc;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cMb;
    }

    public FeatureCardTopic amR() {
        return this.cMc;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.cMc = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.cLR = featureCardTopic.floor;
            this.cLS = featureCardTopic.type;
        }
    }
}
