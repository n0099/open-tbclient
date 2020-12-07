package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes22.dex */
public class h implements q {
    public static BdUniqueId iqH = BdUniqueId.gen();
    private FeatureCardTopic iqI;
    private Integer iqx;
    private Integer iqy;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqH;
    }

    public FeatureCardTopic ctG() {
        return this.iqI;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.iqI = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.iqx = featureCardTopic.floor;
            this.iqy = featureCardTopic.type;
        }
    }
}
