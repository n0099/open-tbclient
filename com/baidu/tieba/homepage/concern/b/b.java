package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId eki = BdUniqueId.gen();
    public static final BdUniqueId ekj = BdUniqueId.gen();
    public bb dqz;
    public c ekk;
    public int ekl;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aIr() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.ekk.getPortrait());
        this.metaData.setName_show(this.ekk.getName());
        this.metaData.setUserId(this.ekk.getUserId());
        this.metaData.setIsBigV(this.ekk.isGod());
        this.metaData.setIsLike(this.ekk.getIsLike());
        this.metaData.setFansNum(this.ekk.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? ekj : eki;
    }

    public int aIs() {
        return this.ekl;
    }

    public void nS(int i) {
        this.ekl = i;
    }
}
