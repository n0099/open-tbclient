package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes9.dex */
public class h implements o {
    public static BdUniqueId gKY = BdUniqueId.gen();
    private Integer gKO;
    private Integer gKP;
    private FeatureCardTopic gKZ;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gKY;
    }

    public FeatureCardTopic bMS() {
        return this.gKZ;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.gKZ = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.gKO = featureCardTopic.floor;
            this.gKP = featureCardTopic.type;
        }
    }
}
