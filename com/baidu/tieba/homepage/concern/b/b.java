package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements i {
    public static final BdUniqueId eca = BdUniqueId.gen();
    public static final BdUniqueId ecb = BdUniqueId.gen();
    public bd duG;
    public c ecc;
    public int ecd;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aAR() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.ecc.getPortrait());
        this.metaData.setName_show(this.ecc.getName());
        this.metaData.setUserId(this.ecc.getUserId());
        this.metaData.setIsBigV(this.ecc.isGod());
        this.metaData.setIsLike(this.ecc.getIsLike());
        this.metaData.setFansNum(this.ecc.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.isLinkThread ? ecb : eca;
    }

    public int aAS() {
        return this.ecd;
    }

    public void ot(int i) {
        this.ecd = i;
    }
}
