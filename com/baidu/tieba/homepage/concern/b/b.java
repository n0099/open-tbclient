package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId etU = BdUniqueId.gen();
    public static final BdUniqueId etV = BdUniqueId.gen();
    public bb dzM;
    public c etW;
    public int etX;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void aKX() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.etW.getPortrait());
        this.metaData.setName_show(this.etW.getName());
        this.metaData.setUserId(this.etW.getUserId());
        this.metaData.setIsBigV(this.etW.isGod());
        this.metaData.setIsLike(this.etW.getIsLike());
        this.metaData.setFansNum(this.etW.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.isLinkThread ? etV : etU;
    }

    public int aKY() {
        return this.etX;
    }

    public void oz(int i) {
        this.etX = i;
    }
}
