package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId fGY = BdUniqueId.gen();
    public static final BdUniqueId fGZ = BdUniqueId.gen();
    public bg eNM;
    public c fHa;
    public int fHb;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void blx() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.fHa.getPortrait());
        this.metaData.setName_show(this.fHa.getName());
        this.metaData.setUserId(this.fHa.getUserId());
        this.metaData.setIsBigV(this.fHa.isGod());
        this.metaData.setIsLike(this.fHa.getIsLike());
        this.metaData.setFansNum(this.fHa.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.isLinkThread ? fGZ : fGY;
    }

    public int bly() {
        return this.fHb;
    }

    public void sj(int i) {
        this.fHb = i;
    }
}
