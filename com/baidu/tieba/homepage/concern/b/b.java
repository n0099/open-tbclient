package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId deR = BdUniqueId.gen();
    public static final BdUniqueId deS = BdUniqueId.gen();
    public bh bfM;
    public c deT;
    public int deU;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void arJ() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.deT.getPortrait());
        this.metaData.setName_show(this.deT.getName());
        this.metaData.setUserId(this.deT.getUserId());
        this.metaData.setIsBigV(this.deT.isGod());
        this.metaData.setIsLike(this.deT.getIsLike());
        this.metaData.setFansNum(this.deT.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.isLinkThread ? deS : deR;
    }

    public int arK() {
        return this.deU;
    }

    public void le(int i) {
        this.deU = i;
    }
}
