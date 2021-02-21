package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes2.dex */
public class f implements n {
    public static final BdUniqueId iEq = BdUniqueId.gen();
    private Integer iEk;
    private Integer iEl;
    private FeatureCardGame iEr;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iEq;
    }

    public FeatureCardGame cua() {
        return this.iEr;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.iEr = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.iEk = featureCardGame.floor;
            this.iEl = featureCardGame.type;
        }
    }
}
