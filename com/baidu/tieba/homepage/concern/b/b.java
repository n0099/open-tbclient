package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId cPg = BdUniqueId.gen();
    public c cPh;
    public MetaData ckW;

    public void anO() {
        this.ckW = new MetaData();
        this.ckW.setPortrait(this.cPh.getPortrait());
        this.ckW.setName_show(this.cPh.getName());
        this.ckW.setUserId(this.cPh.getUserId());
        this.ckW.setIsBigV(this.cPh.isGod());
        this.ckW.setIsLike(this.cPh.getIsLike());
        this.ckW.setFansNum(this.cPh.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cPg;
    }
}
