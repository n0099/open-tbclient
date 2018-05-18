package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId dCv = BdUniqueId.gen();
    public static final BdUniqueId dCw = BdUniqueId.gen();
    public bd cRB;
    public c dCx;
    public int dCy;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void axm() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.dCx.getPortrait());
        this.metaData.setName_show(this.dCx.getName());
        this.metaData.setUserId(this.dCx.getUserId());
        this.metaData.setIsBigV(this.dCx.isGod());
        this.metaData.setIsLike(this.dCx.getIsLike());
        this.metaData.setFansNum(this.dCx.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? dCw : dCv;
    }

    public int axn() {
        return this.dCy;
    }

    public void lT(int i) {
        this.dCy = i;
    }
}
