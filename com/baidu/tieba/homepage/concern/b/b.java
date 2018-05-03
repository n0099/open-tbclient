package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId dBo = BdUniqueId.gen();
    public static final BdUniqueId dBp = BdUniqueId.gen();
    public bd cQu;
    public c dBq;
    public int dBr;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void axn() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.dBq.getPortrait());
        this.metaData.setName_show(this.dBq.getName());
        this.metaData.setUserId(this.dBq.getUserId());
        this.metaData.setIsBigV(this.dBq.isGod());
        this.metaData.setIsLike(this.dBq.getIsLike());
        this.metaData.setFansNum(this.dBq.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? dBp : dBo;
    }

    public int axo() {
        return this.dBr;
    }

    public void lU(int i) {
        this.dBr = i;
    }
}
