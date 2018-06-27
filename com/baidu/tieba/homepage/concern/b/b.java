package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bc;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId dQT = BdUniqueId.gen();
    public static final BdUniqueId dQU = BdUniqueId.gen();
    public bc cYJ;
    public c dQV;
    public int dQW;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aCJ() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.dQV.getPortrait());
        this.metaData.setName_show(this.dQV.getName());
        this.metaData.setUserId(this.dQV.getUserId());
        this.metaData.setIsBigV(this.dQV.isGod());
        this.metaData.setIsLike(this.dQV.getIsLike());
        this.metaData.setFansNum(this.dQV.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? dQU : dQT;
    }

    public int aCK() {
        return this.dQW;
    }

    public void mm(int i) {
        this.dQW = i;
    }
}
