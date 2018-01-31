package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements i {
    public static final BdUniqueId ecv = BdUniqueId.gen();
    public static final BdUniqueId ecw = BdUniqueId.gen();
    public bd dvb;
    public c ecx;
    public int ecy;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aAW() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.ecx.getPortrait());
        this.metaData.setName_show(this.ecx.getName());
        this.metaData.setUserId(this.ecx.getUserId());
        this.metaData.setIsBigV(this.ecx.isGod());
        this.metaData.setIsLike(this.ecx.getIsLike());
        this.metaData.setFansNum(this.ecx.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.isLinkThread ? ecw : ecv;
    }

    public int aAX() {
        return this.ecy;
    }

    public void ot(int i) {
        this.ecy = i;
    }
}
