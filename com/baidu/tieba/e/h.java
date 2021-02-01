package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes2.dex */
public class h implements n {
    public static BdUniqueId iEg = BdUniqueId.gen();
    private Integer iDW;
    private Integer iDX;
    private FeatureCardTopic iEh;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iEg;
    }

    public FeatureCardTopic ctV() {
        return this.iEh;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.iEh = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.iDW = featureCardTopic.floor;
            this.iDX = featureCardTopic.type;
        }
    }
}
