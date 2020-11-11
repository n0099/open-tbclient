package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes22.dex */
public class f implements q {
    public static final BdUniqueId ieU = BdUniqueId.gen();
    private Integer ieO;
    private Integer ieP;
    private FeatureCardGame ieV;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ieU;
    }

    public FeatureCardGame cpN() {
        return this.ieV;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.ieV = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.ieO = featureCardGame.floor;
            this.ieP = featureCardGame.type;
        }
    }
}
