package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId cSy = BdUniqueId.gen();
    public c cSz;
    public MetaData cmQ;

    public void aoH() {
        this.cmQ = new MetaData();
        this.cmQ.setPortrait(this.cSz.getPortrait());
        this.cmQ.setName_show(this.cSz.getName());
        this.cmQ.setUserId(this.cSz.getUserId());
        this.cmQ.setIsBigV(this.cSz.isGod());
        this.cmQ.setIsLike(this.cSz.getIsLike());
        this.cmQ.setFansNum(this.cSz.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cSy;
    }
}
