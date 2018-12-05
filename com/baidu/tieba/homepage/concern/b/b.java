package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId erc = BdUniqueId.gen();
    public static final BdUniqueId erd = BdUniqueId.gen();
    public bb dwZ;
    public c ere;
    public int erf;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aKi() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.ere.getPortrait());
        this.metaData.setName_show(this.ere.getName());
        this.metaData.setUserId(this.ere.getUserId());
        this.metaData.setIsBigV(this.ere.isGod());
        this.metaData.setIsLike(this.ere.getIsLike());
        this.metaData.setFansNum(this.ere.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? erd : erc;
    }

    public int aKj() {
        return this.erf;
    }

    public void om(int i) {
        this.erf = i;
    }
}
