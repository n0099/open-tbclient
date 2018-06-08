package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cOd = BdUniqueId.gen();
    private Integer cNX;
    private Integer cNY;
    private FeatureCardGame cOe;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOd;
    }

    public FeatureCardGame anv() {
        return this.cOe;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.cOe = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.cNX = featureCardGame.floor;
            this.cNY = featureCardGame.type;
        }
    }
}
