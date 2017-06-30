package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String bxM = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo bDV = null;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bDV != null && this.bDV.getType() == AdvertAppInfo.SF) {
            return AdvertAppInfo.SO;
        }
        if (this.bDV != null && this.bDV.legoCard != null) {
            return AdvertAppInfo.SR;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.bDV != null ? this.bDV.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean VX() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dw(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dx(boolean z) {
    }

    public AdvertAppInfo VY() {
        return this.bDV;
    }
}
