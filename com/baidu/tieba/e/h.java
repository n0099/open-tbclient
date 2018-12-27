package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId dnv = BdUniqueId.gen();
    private Integer dnk;
    private Integer dnl;
    private FeatureCardTopic dnw;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dnv;
    }

    public FeatureCardTopic auD() {
        return this.dnw;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.dnw = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.dnk = featureCardTopic.floor;
            this.dnl = featureCardTopic.type;
        }
    }
}
