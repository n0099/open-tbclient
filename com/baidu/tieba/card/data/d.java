package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String ema = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo fMw = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.fMw != null && this.fMw.getType() == AdvertAppInfo.cME) {
            return AdvertAppInfo.cMK;
        }
        if (this.fMw != null && this.fMw.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.cMN;
            switch (this.fMw.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.cMO;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.cMP;
                case 7:
                    return AdvertAppInfo.cMQ;
                case 9:
                    return AdvertAppInfo.cMS;
                case 10:
                    return AdvertAppInfo.cMR;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.fMw != null ? this.fMw.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvu() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ks(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void kt(boolean z) {
    }

    public AdvertAppInfo bvv() {
        return this.fMw;
    }
}
