package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId doE = BdUniqueId.gen();
    public static final BdUniqueId doF = BdUniqueId.gen();
    public bd cBz;
    public c doG;
    public int doH;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void atM() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.doG.getPortrait());
        this.metaData.setName_show(this.doG.getName());
        this.metaData.setUserId(this.doG.getUserId());
        this.metaData.setIsBigV(this.doG.isGod());
        this.metaData.setIsLike(this.doG.getIsLike());
        this.metaData.setFansNum(this.doG.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.isLinkThread ? doF : doE;
    }

    public int atN() {
        return this.doH;
    }

    public void lJ(int i) {
        this.doH = i;
    }
}
