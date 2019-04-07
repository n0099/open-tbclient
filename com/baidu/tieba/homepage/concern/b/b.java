package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId fGM = BdUniqueId.gen();
    public static final BdUniqueId fGN = BdUniqueId.gen();
    public bg eNy;
    public c fGO;
    public int fGP;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void blu() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.fGO.getPortrait());
        this.metaData.setName_show(this.fGO.getName());
        this.metaData.setUserId(this.fGO.getUserId());
        this.metaData.setIsBigV(this.fGO.isGod());
        this.metaData.setIsLike(this.fGO.getIsLike());
        this.metaData.setFansNum(this.fGO.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.isLinkThread ? fGN : fGM;
    }

    public int blv() {
        return this.fGP;
    }

    public void sf(int i) {
        this.fGP = i;
    }
}
