package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes2.dex */
public class f implements n {
    public static final BdUniqueId iEc = BdUniqueId.gen();
    private Integer iDW;
    private Integer iDX;
    private FeatureCardGame iEd;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iEc;
    }

    public FeatureCardGame ctT() {
        return this.iEd;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.iEd = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.iDW = featureCardGame.floor;
            this.iDX = featureCardGame.type;
        }
    }
}
