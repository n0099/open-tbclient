package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId cWt = BdUniqueId.gen();
    public static final BdUniqueId cWu = BdUniqueId.gen();
    public bh bfa;
    public c cWv;
    public int cWw;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aoZ() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.cWv.getPortrait());
        this.metaData.setName_show(this.cWv.getName());
        this.metaData.setUserId(this.cWv.getUserId());
        this.metaData.setIsBigV(this.cWv.isGod());
        this.metaData.setIsLike(this.cWv.getIsLike());
        this.metaData.setFansNum(this.cWv.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.isLinkThread ? cWu : cWt;
    }

    public int apa() {
        return this.cWw;
    }

    public void kN(int i) {
        this.cWw = i;
    }
}
