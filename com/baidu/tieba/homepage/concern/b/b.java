package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId eaU = BdUniqueId.gen();
    public static final BdUniqueId eaV = BdUniqueId.gen();
    public bb dhr;
    public c eaW;
    public int eaX;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aFB() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.eaW.getPortrait());
        this.metaData.setName_show(this.eaW.getName());
        this.metaData.setUserId(this.eaW.getUserId());
        this.metaData.setIsBigV(this.eaW.isGod());
        this.metaData.setIsLike(this.eaW.getIsLike());
        this.metaData.setFansNum(this.eaW.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? eaV : eaU;
    }

    public int aFC() {
        return this.eaX;
    }

    public void nc(int i) {
        this.eaX = i;
    }
}
