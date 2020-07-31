package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String eKO = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo gZK = null;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.gZK != null && this.gZK.getType() == AdvertAppInfo.dMF) {
            return AdvertAppInfo.dML;
        }
        if (this.gZK != null && this.gZK.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.dMO;
            switch (this.gZK.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.dMP;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.dMQ;
                case 7:
                case 14:
                    return AdvertAppInfo.dMR;
                case 12:
                    return AdvertAppInfo.dMT;
                case 13:
                    return AdvertAppInfo.dMS;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.gZK != null ? this.gZK.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bSe() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void mK(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void mL(boolean z) {
    }

    public AdvertAppInfo bSf() {
        return this.gZK;
    }
}
