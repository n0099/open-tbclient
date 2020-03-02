package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes.dex */
public class d extends b implements p {
    public String emb = "";
    public int mPn = 0;
    public String mPageType = "";
    public AdvertAppInfo fMy = null;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.fMy != null && this.fMy.getType() == AdvertAppInfo.cMF) {
            return AdvertAppInfo.cML;
        }
        if (this.fMy != null && this.fMy.legoCard != null) {
            BdUniqueId bdUniqueId = AdvertAppInfo.cMO;
            switch (this.fMy.legoCard.getGoodsStyle()) {
                case 2:
                case 8:
                    return AdvertAppInfo.cMP;
                case 3:
                case 4:
                case 5:
                default:
                    return bdUniqueId;
                case 6:
                    return AdvertAppInfo.cMQ;
                case 7:
                    return AdvertAppInfo.cMR;
                case 9:
                    return AdvertAppInfo.cMT;
                case 10:
                    return AdvertAppInfo.cMS;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        return com.baidu.adp.lib.f.b.toInt(this.fMy != null ? this.fMy.adPosition : "-1", -1);
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvw() {
        return false;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ks(boolean z) {
    }

    @Override // com.baidu.tieba.card.data.p
    public void kt(boolean z) {
    }

    public AdvertAppInfo bvx() {
        return this.fMy;
    }
}
