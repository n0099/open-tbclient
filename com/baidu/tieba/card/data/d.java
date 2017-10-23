package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String ayT = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bNd = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bNd != null && this.bNd.getType() == AdvertAppInfo.Tz) {
            return AdvertAppInfo.TI;
        }
        if (this.bNd != null && this.bNd.legoCard != null) {
            return AdvertAppInfo.TL;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bNd != null ? this.bNd.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean XV() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dC(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dD(boolean z) {
    }

    public AdvertAppInfo XW() {
        return this.bNd;
    }
}
