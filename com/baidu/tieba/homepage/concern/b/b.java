package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId eiO = BdUniqueId.gen();
    public static final BdUniqueId eiP = BdUniqueId.gen();
    public bb dpv;
    public c eiQ;
    public int eiR;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aIT() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.eiQ.getPortrait());
        this.metaData.setName_show(this.eiQ.getName());
        this.metaData.setUserId(this.eiQ.getUserId());
        this.metaData.setIsBigV(this.eiQ.isGod());
        this.metaData.setIsLike(this.eiQ.getIsLike());
        this.metaData.setFansNum(this.eiQ.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? eiP : eiO;
    }

    public int aIU() {
        return this.eiR;
    }

    public void nA(int i) {
        this.eiR = i;
    }
}
