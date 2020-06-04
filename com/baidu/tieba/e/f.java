package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes9.dex */
public class f implements o {
    public static final BdUniqueId gKU = BdUniqueId.gen();
    private Integer gKO;
    private Integer gKP;
    private FeatureCardGame gKV;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gKU;
    }

    public FeatureCardGame bMQ() {
        return this.gKV;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.gKV = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.gKO = featureCardGame.floor;
            this.gKP = featureCardGame.type;
        }
    }
}
