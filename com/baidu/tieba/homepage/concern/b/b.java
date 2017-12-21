package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b implements f {
    public static final BdUniqueId doI = BdUniqueId.gen();
    public static final BdUniqueId doJ = BdUniqueId.gen();
    public bd cBD;
    public c doK;
    public int doL;
    public boolean isLinkThread = false;
    public MetaData metaData;

    public void atM() {
        this.metaData = new MetaData();
        this.metaData.setPortrait(this.doK.getPortrait());
        this.metaData.setName_show(this.doK.getName());
        this.metaData.setUserId(this.doK.getUserId());
        this.metaData.setIsBigV(this.doK.isGod());
        this.metaData.setIsLike(this.doK.getIsLike());
        this.metaData.setFansNum(this.doK.getFansNum());
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.isLinkThread ? doJ : doI;
    }

    public int atN() {
        return this.doL;
    }

    public void lJ(int i) {
        this.doL = i;
    }
}
