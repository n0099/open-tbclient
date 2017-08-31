package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String azO = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bMT = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bMT != null && this.bMT.getType() == AdvertAppInfo.Tx) {
            return AdvertAppInfo.TG;
        }
        if (this.bMT != null && this.bMT.legoCard != null) {
            return AdvertAppInfo.TJ;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bMT != null ? this.bMT.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean Yg() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dJ(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dK(boolean z) {
    }

    public AdvertAppInfo Yh() {
        return this.bMT;
    }
}
