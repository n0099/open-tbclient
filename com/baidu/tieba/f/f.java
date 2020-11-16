package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes21.dex */
public class f implements q {
    public static final BdUniqueId ifJ = BdUniqueId.gen();
    private Integer ifD;
    private Integer ifE;
    private FeatureCardGame ifK;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ifJ;
    }

    public FeatureCardGame cpq() {
        return this.ifK;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.ifK = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.ifD = featureCardGame.floor;
            this.ifE = featureCardGame.type;
        }
    }
}
