package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes22.dex */
public class f implements q {
    public static final BdUniqueId iqF = BdUniqueId.gen();
    private Integer iqA;
    private FeatureCardGame iqG;
    private Integer iqz;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqF;
    }

    public FeatureCardGame ctF() {
        return this.iqG;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.iqG = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.iqz = featureCardGame.floor;
            this.iqA = featureCardGame.type;
        }
    }
}
