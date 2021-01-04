package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes2.dex */
public class f implements n {
    public static final BdUniqueId iCZ = BdUniqueId.gen();
    private Integer iCT;
    private Integer iCU;
    private FeatureCardGame iDa;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iCZ;
    }

    public FeatureCardGame cwy() {
        return this.iDa;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.iDa = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.iCT = featureCardGame.floor;
            this.iCU = featureCardGame.type;
        }
    }
}
