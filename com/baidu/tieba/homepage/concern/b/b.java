package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId dTB = BdUniqueId.gen();
    public static final BdUniqueId dTC = BdUniqueId.gen();
    public c dTD;
    public int dTE;
    public bb dbw;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aDo() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.dTD.getPortrait());
        this.metaData.setName_show(this.dTD.getName());
        this.metaData.setUserId(this.dTD.getUserId());
        this.metaData.setIsBigV(this.dTD.isGod());
        this.metaData.setIsLike(this.dTD.getIsLike());
        this.metaData.setFansNum(this.dTD.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? dTC : dTB;
    }

    public int aDp() {
        return this.dTE;
    }

    public void my(int i) {
        this.dTE = i;
    }
}
