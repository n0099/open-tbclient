package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId cQz = BdUniqueId.gen();
    public c cQA;
    public MetaData cmf;

    public void aoa() {
        this.cmf = new MetaData();
        this.cmf.setPortrait(this.cQA.getPortrait());
        this.cmf.setName_show(this.cQA.getName());
        this.cmf.setUserId(this.cQA.getUserId());
        this.cmf.setIsBigV(this.cQA.isGod());
        this.cmf.setIsLike(this.cQA.getIsLike());
        this.cmf.setFansNum(this.cQA.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cQz;
    }
}
