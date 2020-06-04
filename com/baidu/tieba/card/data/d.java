package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String evm = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo gHg = null;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        if (this.gHg != null && this.gHg.getType() == AdvertAppInfo.dAd) {
            return AdvertAppInfo.dAj;
        }
        if (this.gHg != null && this.gHg.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.dAm;
            switch (this.gHg.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.dAn;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.dAo;
                case 7:
                case 14:
                    return AdvertAppInfo.dAp;
                case 12:
                    return AdvertAppInfo.dAr;
                case 13:
                    return AdvertAppInfo.dAq;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.gHg != null ? this.gHg.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bLI() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void lW(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void lX(boolean z) {
    }

    public AdvertAppInfo bLJ() {
        return this.gHg;
    }
}
