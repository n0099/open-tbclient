package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.be;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements i {
    public static final BdUniqueId eaQ = BdUniqueId.gen();
    public static final BdUniqueId eaR = BdUniqueId.gen();
    public be dqg;
    public c eaS;
    public int eaT;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aAP() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.eaS.getPortrait());
        this.metaData.setName_show(this.eaS.getName());
        this.metaData.setUserId(this.eaS.getUserId());
        this.metaData.setIsBigV(this.eaS.isGod());
        this.metaData.setIsLike(this.eaS.getIsLike());
        this.metaData.setFansNum(this.eaS.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.isLinkThread ? eaR : eaQ;
    }

    public int aAQ() {
        return this.eaT;
    }

    public void oA(int i) {
        this.eaT = i;
    }
}
