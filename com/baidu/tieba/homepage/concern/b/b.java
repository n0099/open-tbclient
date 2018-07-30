package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId dTG = BdUniqueId.gen();
    public static final BdUniqueId dTH = BdUniqueId.gen();
    public c dTI;
    public int dTJ;
    public bb dbA;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aDr() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.dTI.getPortrait());
        this.metaData.setName_show(this.dTI.getName());
        this.metaData.setUserId(this.dTI.getUserId());
        this.metaData.setIsBigV(this.dTI.isGod());
        this.metaData.setIsLike(this.dTI.getIsLike());
        this.metaData.setFansNum(this.dTI.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? dTH : dTG;
    }

    public int aDs() {
        return this.dTJ;
    }

    public void my(int i) {
        this.dTJ = i;
    }
}
