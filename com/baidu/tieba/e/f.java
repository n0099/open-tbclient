package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId ddS = BdUniqueId.gen();
    private Integer ddM;
    private Integer ddN;
    private FeatureCardGame ddT;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ddS;
    }

    public FeatureCardGame asa() {
        return this.ddT;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.ddT = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.ddM = featureCardGame.floor;
            this.ddN = featureCardGame.type;
        }
    }
}
