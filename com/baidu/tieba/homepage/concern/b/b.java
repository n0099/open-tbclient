package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId euA = BdUniqueId.gen();
    public static final BdUniqueId euB = BdUniqueId.gen();
    public bb dAv;
    public c euC;
    public int euD;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aLv() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.euC.getPortrait());
        this.metaData.setName_show(this.euC.getName());
        this.metaData.setUserId(this.euC.getUserId());
        this.metaData.setIsBigV(this.euC.isGod());
        this.metaData.setIsLike(this.euC.getIsLike());
        this.metaData.setFansNum(this.euC.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? euB : euA;
    }

    public int aLw() {
        return this.euD;
    }

    public void oA(int i) {
        this.euD = i;
    }
}
