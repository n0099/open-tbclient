package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dof = BdUniqueId.gen();
    private Integer dnY;
    private Integer dnZ;
    private FeatureCardGame dog;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dof;
    }

    public FeatureCardGame auZ() {
        return this.dog;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.dog = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.dnY = featureCardGame.floor;
            this.dnZ = featureCardGame.type;
        }
    }
}
