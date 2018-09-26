package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cUu = BdUniqueId.gen();
    private Integer cUo;
    private Integer cUp;
    private FeatureCardGame cUv;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUu;
    }

    public FeatureCardGame apc() {
        return this.cUv;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.cUv = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.cUo = featureCardGame.floor;
            this.cUp = featureCardGame.type;
        }
    }
}
