package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes16.dex */
public class f implements q {
    public static final BdUniqueId hdw = BdUniqueId.gen();
    private Integer hdq;
    private Integer hdr;
    private FeatureCardGame hdx;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hdw;
    }

    public FeatureCardGame bTh() {
        return this.hdx;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.hdx = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.hdq = featureCardGame.floor;
            this.hdr = featureCardGame.type;
        }
    }
}
