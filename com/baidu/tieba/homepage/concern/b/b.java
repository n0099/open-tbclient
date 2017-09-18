package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId cZQ = BdUniqueId.gen();
    public static final BdUniqueId cZR = BdUniqueId.gen();
    public bj bdn;
    public c cZS;
    public MetaData ctd;
    public boolean isLinkThread = false;

    public void aqu() {
        this.ctd = new MetaData();
        this.ctd.setPortrait(this.cZS.getPortrait());
        this.ctd.setName_show(this.cZS.getName());
        this.ctd.setUserId(this.cZS.getUserId());
        this.ctd.setIsBigV(this.cZS.isGod());
        this.ctd.setIsLike(this.cZS.getIsLike());
        this.ctd.setFansNum(this.cZS.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.isLinkThread ? cZR : cZQ;
    }
}
