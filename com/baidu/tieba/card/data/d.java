package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String czo = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo czn = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.czn != null && this.czn.getType() == AdvertAppInfo.adJ) {
            return AdvertAppInfo.adP;
        }
        if (this.czn != null && this.czn.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.adS;
            switch (this.czn.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.adT;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.adU;
                case 7:
                    return AdvertAppInfo.adV;
                case 9:
                    return AdvertAppInfo.adX;
                case 10:
                    return AdvertAppInfo.adW;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.czn != null ? this.czn.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean aiQ() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eA(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
    }

    public AdvertAppInfo aiR() {
        return this.czn;
    }
}
