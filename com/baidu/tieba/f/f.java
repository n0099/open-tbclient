package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes22.dex */
public class f implements q {
    public static final BdUniqueId iqD = BdUniqueId.gen();
    private FeatureCardGame iqE;
    private Integer iqx;
    private Integer iqy;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqD;
    }

    public FeatureCardGame ctE() {
        return this.iqE;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.iqE = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.iqx = featureCardGame.floor;
            this.iqy = featureCardGame.type;
        }
    }
}
