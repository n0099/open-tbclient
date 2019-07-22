package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes4.dex */
public class f implements m {
    public static final BdUniqueId eSn = BdUniqueId.gen();
    private Integer eSh;
    private Integer eSi;
    private FeatureCardGame eSo;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSn;
    }

    public FeatureCardGame bea() {
        return this.eSo;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.eSo = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.eSh = featureCardGame.floor;
            this.eSi = featureCardGame.type;
        }
    }
}
