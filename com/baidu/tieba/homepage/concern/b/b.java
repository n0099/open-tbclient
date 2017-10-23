package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId cWh = BdUniqueId.gen();
    public static final BdUniqueId cWi = BdUniqueId.gen();
    public bh beM;
    public c cWj;
    public int cWk;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aoU() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.cWj.getPortrait());
        this.metaData.setName_show(this.cWj.getName());
        this.metaData.setUserId(this.cWj.getUserId());
        this.metaData.setIsBigV(this.cWj.isGod());
        this.metaData.setIsLike(this.cWj.getIsLike());
        this.metaData.setFansNum(this.cWj.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.isLinkThread ? cWi : cWh;
    }

    public int aoV() {
        return this.cWk;
    }

    public void kM(int i) {
        this.cWk = i;
    }
}
