package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes2.dex */
public class f implements n {
    public static final BdUniqueId iFZ = BdUniqueId.gen();
    private Integer iFT;
    private Integer iFU;
    private FeatureCardGame iGa;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iFZ;
    }

    public FeatureCardGame cug() {
        return this.iGa;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.iGa = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.iFT = featureCardGame.floor;
            this.iFU = featureCardGame.type;
        }
    }
}
