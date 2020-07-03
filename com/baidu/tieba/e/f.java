package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes9.dex */
public class f implements q {
    public static final BdUniqueId gXR = BdUniqueId.gen();
    private Integer gXL;
    private Integer gXM;
    private FeatureCardGame gXS;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gXR;
    }

    public FeatureCardGame bPV() {
        return this.gXS;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.gXS = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.gXL = featureCardGame.floor;
            this.gXM = featureCardGame.type;
        }
    }
}
