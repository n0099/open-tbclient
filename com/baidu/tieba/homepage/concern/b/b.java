package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements i {
    public static final BdUniqueId egH = BdUniqueId.gen();
    public static final BdUniqueId egI = BdUniqueId.gen();
    public bd dxT;
    public c egJ;
    public int egK;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aCq() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.egJ.getPortrait());
        this.metaData.setName_show(this.egJ.getName());
        this.metaData.setUserId(this.egJ.getUserId());
        this.metaData.setIsBigV(this.egJ.isGod());
        this.metaData.setIsLike(this.egJ.getIsLike());
        this.metaData.setFansNum(this.egJ.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.isLinkThread ? egI : egH;
    }

    public int aCr() {
        return this.egK;
    }

    public void ou(int i) {
        this.egK = i;
    }
}
