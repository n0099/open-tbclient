package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes4.dex */
public class f implements m {
    public static final BdUniqueId eSu = BdUniqueId.gen();
    private Integer eSo;
    private Integer eSp;
    private FeatureCardGame eSv;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSu;
    }

    public FeatureCardGame bec() {
        return this.eSv;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.eSv = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.eSo = featureCardGame.floor;
            this.eSp = featureCardGame.type;
        }
    }
}
