package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId fGZ = BdUniqueId.gen();
    public static final BdUniqueId fHa = BdUniqueId.gen();
    public bg eNQ;
    public c fHb;
    public int fHc;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void bly() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.fHb.getPortrait());
        this.metaData.setName_show(this.fHb.getName());
        this.metaData.setUserId(this.fHb.getUserId());
        this.metaData.setIsBigV(this.fHb.isGod());
        this.metaData.setIsLike(this.fHb.getIsLike());
        this.metaData.setFansNum(this.fHb.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.isLinkThread ? fHa : fGZ;
    }

    public int blz() {
        return this.fHc;
    }

    public void sj(int i) {
        this.fHc = i;
    }
}
