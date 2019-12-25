package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String fGQ = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo fGP = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.fGP != null && this.fGP.getType() == AdvertAppInfo.cIp) {
            return AdvertAppInfo.cIv;
        }
        if (this.fGP != null && this.fGP.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.cIy;
            switch (this.fGP.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.cIz;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.cIA;
                case 7:
                    return AdvertAppInfo.cIB;
                case 9:
                    return AdvertAppInfo.cID;
                case 10:
                    return AdvertAppInfo.cIC;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.fGP != null ? this.fGP.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bsO() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kf(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void kg(boolean z) {
    }

    public AdvertAppInfo bsP() {
        return this.fGP;
    }
}
