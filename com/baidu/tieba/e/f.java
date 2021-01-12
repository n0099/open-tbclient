package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes2.dex */
public class f implements n {
    public static final BdUniqueId iys = BdUniqueId.gen();
    private Integer iym;
    private Integer iyn;
    private FeatureCardGame iyt;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iys;
    }

    public FeatureCardGame csH() {
        return this.iyt;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.iyt = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.iym = featureCardGame.floor;
            this.iyn = featureCardGame.type;
        }
    }
}
