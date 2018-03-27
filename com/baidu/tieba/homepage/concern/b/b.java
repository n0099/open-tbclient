package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements i {
    public static final BdUniqueId egL = BdUniqueId.gen();
    public static final BdUniqueId egM = BdUniqueId.gen();
    public bd dxK;
    public c egN;
    public int egO;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aCq() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.egN.getPortrait());
        this.metaData.setName_show(this.egN.getName());
        this.metaData.setUserId(this.egN.getUserId());
        this.metaData.setIsBigV(this.egN.isGod());
        this.metaData.setIsLike(this.egN.getIsLike());
        this.metaData.setFansNum(this.egN.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.isLinkThread ? egM : egL;
    }

    public int aCr() {
        return this.egO;
    }

    public void ov(int i) {
        this.egO = i;
    }
}
