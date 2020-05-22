package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes9.dex */
public class f implements o {
    public static final BdUniqueId gKJ = BdUniqueId.gen();
    private Integer gKD;
    private Integer gKE;
    private FeatureCardGame gKK;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gKJ;
    }

    public FeatureCardGame bMO() {
        return this.gKK;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.gKK = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.gKD = featureCardGame.floor;
            this.gKE = featureCardGame.type;
        }
    }
}
