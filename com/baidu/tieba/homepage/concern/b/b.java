package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId dNB = BdUniqueId.gen();
    public static final BdUniqueId dNC = BdUniqueId.gen();
    public c dND;
    public int dNE;
    public bd daI;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aCf() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.dND.getPortrait());
        this.metaData.setName_show(this.dND.getName());
        this.metaData.setUserId(this.dND.getUserId());
        this.metaData.setIsBigV(this.dND.isGod());
        this.metaData.setIsLike(this.dND.getIsLike());
        this.metaData.setFansNum(this.dND.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? dNC : dNB;
    }

    public int aCg() {
        return this.dNE;
    }

    public void mf(int i) {
        this.dNE = i;
    }
}
