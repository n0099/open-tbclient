package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cOD = BdUniqueId.gen();
    private FeatureCardGame cOE;
    private Integer cOx;
    private Integer cOy;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOD;
    }

    public FeatureCardGame anq() {
        return this.cOE;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.cOE = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.cOx = featureCardGame.floor;
            this.cOy = featureCardGame.type;
        }
    }
}
