package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cFn = BdUniqueId.gen();
    private Integer cFh;
    private Integer cFi;
    private FeatureCardGame cFo;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cFn;
    }

    public FeatureCardGame ajy() {
        return this.cFo;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.cFo = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.cFh = featureCardGame.floor;
            this.cFi = featureCardGame.type;
        }
    }
}
