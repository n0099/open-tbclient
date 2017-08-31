package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId cYW = BdUniqueId.gen();
    public static final BdUniqueId cYX = BdUniqueId.gen();
    public bj bdq;
    public c cYY;
    public MetaData csl;
    public boolean isLinkThread = false;

    public void aqj() {
        this.csl = new MetaData();
        this.csl.setPortrait(this.cYY.getPortrait());
        this.csl.setName_show(this.cYY.getName());
        this.csl.setUserId(this.cYY.getUserId());
        this.csl.setIsBigV(this.cYY.isGod());
        this.csl.setIsLike(this.cYY.getIsLike());
        this.csl.setFansNum(this.cYY.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.isLinkThread ? cYX : cYW;
    }
}
