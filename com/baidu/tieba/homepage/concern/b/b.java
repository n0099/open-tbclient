package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId dny = BdUniqueId.gen();
    public static final BdUniqueId dnz = BdUniqueId.gen();
    public bd cBr;
    public c dnA;
    public int dnB;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void atD() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.dnA.getPortrait());
        this.metaData.setName_show(this.dnA.getName());
        this.metaData.setUserId(this.dnA.getUserId());
        this.metaData.setIsBigV(this.dnA.isGod());
        this.metaData.setIsLike(this.dnA.getIsLike());
        this.metaData.setFansNum(this.dnA.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.isLinkThread ? dnz : dny;
    }

    public int atE() {
        return this.dnB;
    }

    public void lC(int i) {
        this.dnB = i;
    }
}
