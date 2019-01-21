package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId euB = BdUniqueId.gen();
    public static final BdUniqueId euC = BdUniqueId.gen();
    public bb dAw;
    public c euD;
    public int euE;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aLv() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.euD.getPortrait());
        this.metaData.setName_show(this.euD.getName());
        this.metaData.setUserId(this.euD.getUserId());
        this.metaData.setIsBigV(this.euD.isGod());
        this.metaData.setIsLike(this.euD.getIsLike());
        this.metaData.setFansNum(this.euD.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? euC : euB;
    }

    public int aLw() {
        return this.euE;
    }

    public void oA(int i) {
        this.euE = i;
    }
}
