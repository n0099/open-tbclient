package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId dex = BdUniqueId.gen();
    public static final BdUniqueId dey = BdUniqueId.gen();
    public bh bfD;
    public int deA;
    public c dez;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void art() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.dez.getPortrait());
        this.metaData.setName_show(this.dez.getName());
        this.metaData.setUserId(this.dez.getUserId());
        this.metaData.setIsBigV(this.dez.isGod());
        this.metaData.setIsLike(this.dez.getIsLike());
        this.metaData.setFansNum(this.dez.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.isLinkThread ? dey : dex;
    }

    public int aru() {
        return this.deA;
    }

    public void le(int i) {
        this.deA = i;
    }
}
