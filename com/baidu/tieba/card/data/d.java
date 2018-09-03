package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String cBR = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cBQ = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.cBQ != null && this.cBQ.getType() == AdvertAppInfo.adn) {
            return AdvertAppInfo.adt;
        }
        if (this.cBQ != null && this.cBQ.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.adw;
            switch (this.cBQ.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.adx;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.ady;
                case 7:
                    return AdvertAppInfo.adz;
                case 9:
                    return AdvertAppInfo.adB;
                case 10:
                    return AdvertAppInfo.adA;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.g(this.cBQ != null ? this.cBQ.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ajs() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void eC(boolean z) {
    }

    public AdvertAppInfo ajt() {
        return this.cBQ;
    }
}
