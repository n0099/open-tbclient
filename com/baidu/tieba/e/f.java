package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dcM = BdUniqueId.gen();
    private Integer dcG;
    private Integer dcH;
    private FeatureCardGame dcN;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dcM;
    }

    public FeatureCardGame asB() {
        return this.dcN;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.dcN = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.dcG = featureCardGame.floor;
            this.dcH = featureCardGame.type;
        }
    }
}
