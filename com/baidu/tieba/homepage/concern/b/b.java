package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements i {
    public static final BdUniqueId egv = BdUniqueId.gen();
    public static final BdUniqueId egw = BdUniqueId.gen();
    public bd dxH;
    public c egx;
    public int egy;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aCp() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.egx.getPortrait());
        this.metaData.setName_show(this.egx.getName());
        this.metaData.setUserId(this.egx.getUserId());
        this.metaData.setIsBigV(this.egx.isGod());
        this.metaData.setIsLike(this.egx.getIsLike());
        this.metaData.setFansNum(this.egx.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.isLinkThread ? egw : egv;
    }

    public int aCq() {
        return this.egy;
    }

    public void ou(int i) {
        this.egy = i;
    }
}
