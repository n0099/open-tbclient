package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId dBr = BdUniqueId.gen();
    public static final BdUniqueId dBs = BdUniqueId.gen();
    public bd cQx;
    public c dBt;
    public int dBu;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void axn() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.dBt.getPortrait());
        this.metaData.setName_show(this.dBt.getName());
        this.metaData.setUserId(this.dBt.getUserId());
        this.metaData.setIsBigV(this.dBt.isGod());
        this.metaData.setIsLike(this.dBt.getIsLike());
        this.metaData.setFansNum(this.dBt.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? dBs : dBr;
    }

    public int axo() {
        return this.dBu;
    }

    public void lV(int i) {
        this.dBu = i;
    }
}
