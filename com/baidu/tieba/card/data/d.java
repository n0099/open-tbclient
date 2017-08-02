package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String azk = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bIh = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bIh != null && this.bIh.getType() == AdvertAppInfo.SU) {
            return AdvertAppInfo.Td;
        }
        if (this.bIh != null && this.bIh.legoCard != null) {
            return AdvertAppInfo.Tg;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bIh != null ? this.bIh.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean WF() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dF(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dG(boolean z) {
    }

    public AdvertAppInfo WG() {
        return this.bIh;
    }
}
