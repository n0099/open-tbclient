package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId cSy = BdUniqueId.gen();
    public c cSz;
    public MetaData cmR;

    public void aoB() {
        this.cmR = new MetaData();
        this.cmR.setPortrait(this.cSz.getPortrait());
        this.cmR.setName_show(this.cSz.getName());
        this.cmR.setUserId(this.cSz.getUserId());
        this.cmR.setIsBigV(this.cSz.isGod());
        this.cmR.setIsLike(this.cSz.getIsLike());
        this.cmR.setFansNum(this.cSz.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cSy;
    }
}
