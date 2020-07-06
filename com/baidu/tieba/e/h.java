package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes9.dex */
public class h implements q {
    public static BdUniqueId gXV = BdUniqueId.gen();
    private Integer gXL;
    private Integer gXM;
    private FeatureCardTopic gXW;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gXV;
    }

    public FeatureCardTopic bPY() {
        return this.gXW;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.gXW = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.gXL = featureCardTopic.floor;
            this.gXM = featureCardTopic.type;
        }
    }
}
