package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String azL = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bNK = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bNK != null && this.bNK.getType() == AdvertAppInfo.Tx) {
            return AdvertAppInfo.TG;
        }
        if (this.bNK != null && this.bNK.legoCard != null) {
            return AdvertAppInfo.TJ;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bNK != null ? this.bNK.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Yr() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dK(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dL(boolean z) {
    }

    public AdvertAppInfo Ys() {
        return this.bNK;
    }
}
