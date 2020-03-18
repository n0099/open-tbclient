package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String emF = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo fNt = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.fNt != null && this.fNt.getType() == AdvertAppInfo.cMR) {
            return AdvertAppInfo.cMX;
        }
        if (this.fNt != null && this.fNt.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.cNa;
            switch (this.fNt.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.cNb;
                case 3:
                case 4:
                case 5:
                case 11:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.cNc;
                case 7:
                    return AdvertAppInfo.cNd;
                case 9:
                    return AdvertAppInfo.cNf;
                case 10:
                    return AdvertAppInfo.cNe;
                case 12:
                    return AdvertAppInfo.cNh;
                case 13:
                    return AdvertAppInfo.cNg;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.fNt != null ? this.fNt.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvC() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kx(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void ky(boolean z) {
    }

    public AdvertAppInfo bvD() {
        return this.fNt;
    }
}
