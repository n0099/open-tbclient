package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dnq = BdUniqueId.gen();
    private Integer dnk;
    private Integer dnl;
    private FeatureCardGame dnr;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dnq;
    }

    public FeatureCardGame auB() {
        return this.dnr;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.dnr = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.dnk = featureCardGame.floor;
            this.dnl = featureCardGame.type;
        }
    }
}
