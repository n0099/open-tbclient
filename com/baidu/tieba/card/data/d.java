package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements r {
    public String aAn = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cdo = null;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.cdo != null && this.cdo.getType() == AdvertAppInfo.Uz) {
            return AdvertAppInfo.UG;
        }
        if (this.cdo != null && this.cdo.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.UJ;
            switch (this.cdo.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.UK;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.UL;
                case 7:
                    return AdvertAppInfo.UM;
                case 9:
                    return AdvertAppInfo.UO;
                case 10:
                    return AdvertAppInfo.UN;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.cdo != null ? this.cdo.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean aca() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dV(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.r
    public void dW(boolean z) {
    }

    public AdvertAppInfo acb() {
        return this.cdo;
    }
}
