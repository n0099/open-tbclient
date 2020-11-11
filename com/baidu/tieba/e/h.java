package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes22.dex */
public class h implements q {
    public static BdUniqueId ieY = BdUniqueId.gen();
    private Integer ieO;
    private Integer ieP;
    private FeatureCardTopic ieZ;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ieY;
    }

    public FeatureCardTopic cpP() {
        return this.ieZ;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.ieZ = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.ieO = featureCardTopic.floor;
            this.ieP = featureCardTopic.type;
        }
    }
}
