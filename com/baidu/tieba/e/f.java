package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId doe = BdUniqueId.gen();
    private Integer dnX;
    private Integer dnY;
    private FeatureCardGame dof;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return doe;
    }

    public FeatureCardGame auZ() {
        return this.dof;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.dof = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.dnX = featureCardGame.floor;
            this.dnY = featureCardGame.type;
        }
    }
}
