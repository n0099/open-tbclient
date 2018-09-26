package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String cHI = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo cHH = null;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.cHH != null && this.cHH.getType() == AdvertAppInfo.afN) {
            return AdvertAppInfo.afT;
        }
        if (this.cHH != null && this.cHH.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.afW;
            switch (this.cHH.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.afX;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.afY;
                case 7:
                    return AdvertAppInfo.afZ;
                case 9:
                    return AdvertAppInfo.agb;
                case 10:
                    return AdvertAppInfo.aga;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.g.b.l(this.cHH != null ? this.cHH.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ald() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eS(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void eT(boolean z) {
    }

    public AdvertAppInfo ale() {
        return this.cHH;
    }
}
