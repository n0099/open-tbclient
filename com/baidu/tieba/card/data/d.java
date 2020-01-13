package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String fKa = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo fJZ = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.fJZ != null && this.fJZ.getType() == AdvertAppInfo.cIB) {
            return AdvertAppInfo.cIH;
        }
        if (this.fJZ != null && this.fJZ.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.cIK;
            switch (this.fJZ.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.cIL;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.cIM;
                case 7:
                    return AdvertAppInfo.cIN;
                case 9:
                    return AdvertAppInfo.cIP;
                case 10:
                    return AdvertAppInfo.cIO;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.fJZ != null ? this.fJZ.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean btQ() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kq(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void kr(boolean z) {
    }

    public AdvertAppInfo btR() {
        return this.fJZ;
    }
}
