package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId eiN = BdUniqueId.gen();
    public static final BdUniqueId eiO = BdUniqueId.gen();
    public bb dpv;
    public c eiP;
    public int eiQ;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aIT() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.eiP.getPortrait());
        this.metaData.setName_show(this.eiP.getName());
        this.metaData.setUserId(this.eiP.getUserId());
        this.metaData.setIsBigV(this.eiP.isGod());
        this.metaData.setIsLike(this.eiP.getIsLike());
        this.metaData.setFansNum(this.eiP.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? eiO : eiN;
    }

    public int aIU() {
        return this.eiQ;
    }

    public void nA(int i) {
        this.eiQ = i;
    }
}
