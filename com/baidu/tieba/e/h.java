package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
/* loaded from: classes21.dex */
public class h implements q {
    public static BdUniqueId hxF = BdUniqueId.gen();
    private FeatureCardTopic hxG;
    private Integer hxv;
    private Integer hxw;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hxF;
    }

    public FeatureCardTopic cgL() {
        return this.hxG;
    }

    public void a(FeatureCardTopic featureCardTopic) {
        if (featureCardTopic != null) {
            this.hxG = featureCardTopic;
            this.mTitle = featureCardTopic.title;
            this.hxv = featureCardTopic.floor;
            this.hxw = featureCardTopic.type;
        }
    }
}
